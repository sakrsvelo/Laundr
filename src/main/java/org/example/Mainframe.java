package org.example;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import org.example.gui.forms.Login;
import org.example.gui.forms.Register;
import org.example.gui.utils.fontLoader;

import javax.swing.*;
import java.awt.*;

public class Mainframe extends JFrame {
    private static boolean dark = false;
    private static CardLayout cardLayout;
    private static JPanel mainPanel;

    public Mainframe() {
        fontLoader.loadFonts();
        loadTheme();

        initializeFrame();
        setupUI();
    }

    private void loadTheme() {
        try {
            FlatLaf.registerCustomDefaultsSource("Themes");
            if (dark) {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeFrame() {
        setTitle("Laundr");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width * 3 / 4, screenSize.height * 5 / 6);
        setLocationRelativeTo(null);
    }

    private void setupUI() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new Login(this), "LOGIN");
        mainPanel.add(new Register(this), "REGISTER");
        mainPanel.add(new Landing(this), "LANDING");

        setContentPane(mainPanel);
        showCard("LOGIN");
    }

    public static void showCard(String name) {
        cardLayout.show(mainPanel, name);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void toggleTheme() {
        dark = !dark;

        try {
            FlatLaf.registerCustomDefaultsSource("Themes");
            if (dark) {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
            }

            fontLoader.loadFonts();

            UIManager.put("defaultFont", new Font("Lato Regular", Font.PLAIN, 16));
            UIManager.put("Title.font", new Font("Fredoka Bold", Font.BOLD, 30));
            UIManager.put("Button.font", new Font("Lato Bold", Font.BOLD, 15));

            UIManager.put("headerColor", dark ? new Color(0xF8FBFD) : new Color(0x31A4E5));
            UIManager.put("Button.foreground", new Color(0xF8FBFD));
            UIManager.put("Label.foreground", dark ? new Color(0xF8FBFD) : new Color(0x273755));

            SwingUtilities.updateComponentTreeUI(this);
            revalidate();
            repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isDarkMode() {
        return dark;
    }

}
