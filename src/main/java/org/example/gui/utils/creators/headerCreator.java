package org.example.gui.utils.creators;

import javax.swing.*;
import java.awt.*;

import org.example.Mainframe;

public class headerCreator extends JPanel {
    private final Mainframe frame;
    private JButton toggleBtn;
    private JLabel logoLabel;

    public headerCreator(Mainframe frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(0, 60));
        setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
        leftPanel.setOpaque(false);

        logoLabel = new JLabel(iconCreator.getIcon("Icons/logoWhite.svg", 70, 50));
        leftPanel.add(logoLabel);

        toggleBtn = new themeToggleButton(frame::toggleTheme);

        add(leftPanel, BorderLayout.WEST);
        add(toggleBtn, BorderLayout.EAST);

        updateUI();
    }

    @Override
    public void updateUI() {
        super.updateUI();
        setBackground(UIManager.getColor("Menu.background"));
        setBorder(BorderFactory.createMatteBorder(
                0, 0, 2, 0,
                UIManager.getColor("Menu.borderColor")
        ));
        setForeground(UIManager.getColor("Menu.foreground"));

        if (toggleBtn != null) {
            toggleBtn.setFont(UIManager.getFont("Button.font"));
            Color fg = UIManager.getColor("Button.foreground");
            if (fg != null) toggleBtn.setForeground(fg);
        }

        if (logoLabel != null) {
            logoLabel.setIcon(iconCreator.getIcon(
                    frame.isDarkMode() ? "Icons/logoDarkMode.svg" : "Icons/logoWhite.svg",
                    70, 50
            ));
        }
    }
}
