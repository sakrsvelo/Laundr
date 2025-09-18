package org.example.gui.utils.sidebar;

import org.example.gui.panels.Landing;
import org.example.gui.Mainframe;
import org.example.gui.utils.creators.iconCreator;

import javax.swing.*;
import java.awt.*;

public class sidebarFactory extends JPanel {

    private static final int BUTTON_SPACING = 15;

    public sidebarFactory(Landing landing) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, Integer.MAX_VALUE));
        setOpaque(true);
        setBackground(UIManager.getColor("Menu.background"));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setOpaque(false);

        topPanel.add(Box.createVerticalStrut(BUTTON_SPACING));

        topPanel.add(new sidebarButtons("Home",
                iconCreator.getIcon("Icons/home.svg", 24, 24),
                () -> landing.showCard("DASHBOARD")));
        topPanel.add(Box.createVerticalStrut(BUTTON_SPACING));


        topPanel.add(new sidebarButtons("Laundromats",
                iconCreator.getIcon("Icons/laundromats.svg", 24, 24),
                () -> landing.showCard("LAUNDROMATS")));
        topPanel.add(Box.createVerticalStrut(BUTTON_SPACING));

        topPanel.add(new sidebarButtons("Profile",
                iconCreator.getIcon("Icons/userIcon.svg", 24, 24),
                () -> landing.showCard("PROFILE")));
        topPanel.add(Box.createVerticalStrut(BUTTON_SPACING));

        topPanel.add(new sidebarButtons("Orders",
                iconCreator.getIcon("Icons/order.svg", 24, 24),
                () -> landing.showCard("ORDERS")));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setOpaque(false);

        bottomPanel.add(Box.createVerticalGlue());

        bottomPanel.add(new sidebarButtons("Logout",
                iconCreator.getIcon("Icons/logout.svg", 24, 24),
                () -> Mainframe.showCard("LOGIN")));

        bottomPanel.add(Box.createVerticalStrut(BUTTON_SPACING-5));

        add(topPanel);
        add(Box.createVerticalGlue());
        add(bottomPanel);
    }

    @Override
    public void updateUI() {
        super.updateUI();
        setBackground(UIManager.getColor("Menu.background"));
        setForeground(UIManager.getColor("Menu.foreground"));
    }
}
