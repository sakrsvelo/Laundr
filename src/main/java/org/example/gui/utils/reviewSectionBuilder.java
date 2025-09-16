package org.example.gui.utils;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static org.example.gui.utils.setPanels.createReviewPanel;

public class reviewSectionBuilder {
    public static JPanel buildReviewsSection(List<String> users, List<String> reviews, Icon userIcon) {

        JPanel laundromatReviews = new JPanel(new BorderLayout());
        laundromatReviews.setOpaque(false);
        laundromatReviews.setPreferredSize(new Dimension(0, 520)); // slightly taller

        // Header
        JPanel reviewsLabelPanel = new JPanel(new BorderLayout());
        reviewsLabelPanel.setOpaque(false);
        reviewsLabelPanel.setPreferredSize(new Dimension(0, 50));

        JLabel reviewsLabel = new JLabel("Reviews:");
        reviewsLabel.setFont(UIManager.getFont("Heading.font"));
        reviewsLabel.setForeground(UIManager.getColor("foreground"));

        reviewsLabelPanel.add(reviewsLabel, BorderLayout.WEST);

        JPanel reviewsPanel = new JPanel();
        reviewsPanel.setLayout(new BoxLayout(reviewsPanel, BoxLayout.Y_AXIS));
        reviewsPanel.setOpaque(false);
        reviewsPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(2, 2, 2, 2, UIManager.getColor("listBorder")),
                        BorderFactory.createEmptyBorder(0, 0, 0, 0)
                ));

        for (int i = 0; i < users.size(); i++) {
            JPanel reviewPanel = createReviewPanel(
                    users.get(i),
                    reviews.get(i),
                    userIcon,
                    UIManager.getColor("foreground"),
                    35,
                    true
            );
            reviewPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            reviewPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 173));
            reviewsPanel.add(reviewPanel);
        }

        laundromatReviews.add(reviewsLabelPanel, BorderLayout.NORTH);
        laundromatReviews.add(reviewsPanel, BorderLayout.CENTER);

        return laundromatReviews;
    }
}
