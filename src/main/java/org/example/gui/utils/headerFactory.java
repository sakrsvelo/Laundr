package org.example.gui.utils;

import javax.swing.*;
import java.awt.*;

import org.example.Mainframe;

public class headerFactory extends JPanel {
    private JButton toggleBtn;

    public headerFactory(Mainframe frame) {
        setPreferredSize(new Dimension(0, 50));
        setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        leftPanel.setOpaque(false);

        JLabel menuIcon = new JLabel(iconFactory.getIcon("Icons/menu.svg", 24, 24));
        JLabel logoIcon = new JLabel(iconFactory.getIcon("Icons/logoWhite.svg", 60, 40));

        leftPanel.add(menuIcon);
        leftPanel.add(logoIcon);

        themeToggleButton toggleBtn = new themeToggleButton(frame::toggleTheme);

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
    }
}
