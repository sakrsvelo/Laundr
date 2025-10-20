package org.example.gui.panels;

import org.example.gui.utils.fonts.fontManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class EditProfile extends JPanel {

    public EditProfile() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(40, 50, 20, 50));

        add(createTopSection());
    }

    //top
    private JPanel createTopSection() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setOpaque(false);

        ImageIcon im = new ImageIcon(getClass().getResource("/Pictures/profile pictures/pfp1.png"));
        Image img = im.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel profilePic = new JLabel(new ImageIcon(img));
        profilePic.setPreferredSize(new Dimension(90, 90));
        profilePic.setMaximumSize(new Dimension(90, 90));
        profilePic.setAlignmentY(Component.CENTER_ALIGNMENT);

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        namePanel.setOpaque(false);
        namePanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        namePanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel("John Doe");
        fontManager.applyHeading(nameLabel, 5);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel editProfileLabel = new JLabel("✏ Edit Profile");
        fontManager.applyHeading(editProfileLabel, 6);
        editProfileLabel.setForeground(Color.DARK_GRAY);
        editProfileLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        editProfileLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        return topPanel;
    }
}
