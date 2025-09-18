package org.example.gui.utils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class setPanels {

    public static void laundryPanels(Border border, Color color, Dimension dim, JPanel... panels) {
        for (JPanel panel : panels) {
            panel.setBackground(color);
            panel.setBorder(border);
            panel.setPreferredSize(dim);
        }
    }

    public static JPanel servicePanel(String title, Icon icon, Border border, Color color, Dimension dim) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(color);
        panel.setBorder(border);
        panel.setPreferredSize(dim);

        JLabel label = new JLabel(title, icon, SwingConstants.CENTER);
        label.setFont(UIManager.getFont("Heading.font"));
        label.setForeground(UIManager.getColor("foreground"));
        label.setHorizontalTextPosition(SwingConstants.CENTER); //text centered horizontally
        label.setVerticalTextPosition(SwingConstants.BOTTOM);    //text below icon
        label.setIconTextGap(20);

        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    public static JPanel createReviewPanel(String userName, String reviewText, Icon userIcon, Color textColor, int iconSize, boolean addBottomBorder) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        if (addBottomBorder) {
            panel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, UIManager.getColor("listBorder")));
        }

        JLabel userLabel = new JLabel(userName, userIcon, SwingConstants.LEFT);
        userLabel.setFont(UIManager.getFont("Heading.font"));
        userLabel.setForeground(textColor);
        userLabel.setAlignmentX(Component.LEFT_ALIGNMENT); //align left

        JLabel reviewLabel = new JLabel("<html>" + reviewText + "</html>");
        reviewLabel.setFont(UIManager.getFont("defaultFont"));
        reviewLabel.setForeground(textColor);
        reviewLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        reviewLabel.setBorder(BorderFactory.createEmptyBorder(5, iconSize + 5, 5, 0));

        panel.add(userLabel);
        panel.add(reviewLabel);

        return panel;
    }

}