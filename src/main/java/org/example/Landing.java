package org.example;

import org.example.gui.forms.Dashboard;
import org.example.gui.forms.Orders;
import org.example.gui.forms.Profile;
import org.example.gui.utils.headerFactory;
import org.example.gui.utils.sidebar.sidebarFactory;

import javax.swing.*;
import java.awt.*;

public class Landing extends JPanel {

    private headerFactory header;
    private sidebarFactory sidebar;
    private CardLayout centerLayout;
    private JPanel centerPanel;

    public Landing(Mainframe frame) {
        setLayout(new BorderLayout());
        setBackground(UIManager.getColor("Panel.background"));

        header = new headerFactory(frame);
        add(header, BorderLayout.NORTH);

        centerLayout = new CardLayout();
        centerPanel = new JPanel(centerLayout);

        centerPanel.add(new Dashboard(), "DASHBOARD");
        centerPanel.add(new Profile(), "PROFILE");
        centerPanel.add(new Orders(), "ORDERS");

        add(centerPanel, BorderLayout.CENTER);

        sidebar = new sidebarFactory(this);
        add(sidebar, BorderLayout.WEST);

        centerLayout.show(centerPanel, "DASHBOARD");
    }

    public void showCard(String name) {

        centerLayout.show(centerPanel, name);
    }

    @Override
    public void updateUI() {
        super.updateUI();
        setBackground(UIManager.getColor("Panel.background"));
        if (header != null) header.updateUI();
        if (sidebar != null) sidebar.updateUI();
        if (centerPanel != null) centerPanel.updateUI();
    }
}
