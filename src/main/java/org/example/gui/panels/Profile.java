package org.example.gui.panels;

import org.example.gui.utils.creators.iconCreator;
import org.example.gui.utils.creators.roundedBorder;
import org.example.gui.utils.creators.roundedPanel;
import org.example.gui.utils.fonts.fontManager;

import javax.swing.*;
import java.awt.*;

public class Profile extends JPanel {
    private JLabel nameLabel;
    private JLabel editProfileLabel;
    private JLabel textLabel;

    public Profile() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // === TOP PANEL ===
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
//        topPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        topPanel.setOpaque(false);

        roundedPanel profilePic = new roundedPanel(40);
        profilePic.setPreferredSize(new Dimension(80, 80));
        profilePic.setMaximumSize(new Dimension(80, 80));
        profilePic.setBackground(new Color(220, 220, 220));

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
        userPanel.setOpaque(false);
        userPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        nameLabel = new JLabel("John Doe");
        fontManager.applyHeading(nameLabel, 5);

        editProfileLabel = new JLabel("✏ Edit Profile");
        fontManager.applyHeading(editProfileLabel, 3);
        editProfileLabel.setForeground(Color.DARK_GRAY);

        userPanel.add(nameLabel);
        userPanel.add(editProfileLabel);

        topPanel.add(profilePic);
        topPanel.add(Box.createHorizontalStrut(10));
        topPanel.add(userPanel);

        // === MIDDLE PANEL ===
        roundedPanel middlePanel = new roundedPanel(20);
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));
        middlePanel.setBackground(UIManager.getColor("Profile.background"));
        middlePanel.setBorder(new roundedBorder(20, new Color(200, 200, 200), 1));
        middlePanel.setOpaque(false);
//        middlePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        middlePanel.setBorder(BorderFactory.createCompoundBorder(
                new roundedBorder(20, new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        middlePanel.add(createIconLabelPanel("Icons/lightmode/order.svg", "Orders"));
        middlePanel.add(Box.createHorizontalStrut(20));
        middlePanel.add(createIconLabelPanel("Icons/lightmode/wallet.svg", "Digital Wallet"));
        middlePanel.add(Box.createHorizontalStrut(20));
        middlePanel.add(createIconLabelPanel("Icons/lightmode/toReceive.svg", "To Receive"));
        middlePanel.add(Box.createHorizontalStrut(20));
        middlePanel.add(createIconLabelPanel("Icons/lightmode/rating.svg", "To Rate"));

        // === BOTTOM PANEL ===
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.setOpaque(false);
//        bottomPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        // Saved Laundromats
        roundedPanel savedPanel = new roundedPanel(20);
        savedPanel.setLayout(new BoxLayout(savedPanel, BoxLayout.Y_AXIS));
        savedPanel.setBackground(UIManager.getColor("Profile.background"));
        savedPanel.setBorder(new roundedBorder(20, new Color(200, 200, 200), 1));
        savedPanel.add(createIconLabelPanel("Icons/lightmode/bookmark.svg", "Saved Laundromats"));

        // Support Section
        roundedPanel supportPanel = new roundedPanel(20);
        supportPanel.setLayout(new BoxLayout(supportPanel, BoxLayout.Y_AXIS));
        supportPanel.setBackground(UIManager.getColor("Profile.background"));
        supportPanel.setBorder(new roundedBorder(20, new Color(200, 200, 200), 1));

        JLabel supportLabel = new JLabel("Support");
        supportLabel.setFont(UIManager.getFont("Profile.font"));
        supportLabel.setForeground(UIManager.getColor("Profile.foreground"));
        supportLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel supportItems = new JPanel();
        supportItems.setLayout(new BoxLayout(supportItems, BoxLayout.Y_AXIS));
        supportItems.setOpaque(false);
        supportItems.add(createIconLabelPanel("Icons/lightmode/help.svg", "Help Center"));
        supportItems.add(Box.createVerticalStrut(10));
        supportItems.add(createIconLabelPanel("Icons/lightmode/info.svg", "About Laundr"));

        supportPanel.add(supportLabel);
        supportPanel.add(supportItems);

        bottomPanel.add(savedPanel);
        bottomPanel.add(Box.createHorizontalStrut(30));
        bottomPanel.add(supportPanel);

        // === ADD TO MAIN PANEL ===
        add(topPanel);
        add(Box.createVerticalStrut(20));
        add(middlePanel);
        add(Box.createVerticalStrut(20));
        add(bottomPanel);
    }

    private JPanel createIconLabelPanel(String iconPath, String text) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel iconLabel = new JLabel(iconCreator.getIcon(iconPath, 40, 40));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel textLabel = new JLabel(text, SwingConstants.CENTER);
        fontManager.applyHeading(textLabel, 6);
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(iconLabel);
        panel.add(Box.createVerticalStrut(8));
        panel.add(textLabel);

        return panel;
    }

    @Override
    public void updateUI() {
        super.updateUI();
        if (nameLabel != null) fontManager.applyHeading(nameLabel, 5);
        if (editProfileLabel != null) fontManager.applyHeading(editProfileLabel, 4);
        if(textLabel != null) fontManager.applyHeading(textLabel, 6);
        repaint();
    }
}
