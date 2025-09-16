package org.example.gui.utils.laundrylist;

import org.example.gui.utils.iconCreator;
import org.example.gui.utils.setPanels;

import javax.swing.*;
import java.awt.*;

public class laundromatPanels {

    public static JPanel createLaundryPanel(String name, String distance, String delivery, String imagePath) {
        JPanel laundryPanel = new JPanel(new BorderLayout());

        //picture
        JPanel laundromatPicture = new laundromatImagePanel(imagePath);
        laundromatPicture.setPreferredSize(new Dimension(0, 0));
        laundromatPicture.setLayout(new BorderLayout());

        //south info container
        JPanel south = new JPanel(new BorderLayout());
        south.setOpaque(false);
        south.setPreferredSize(new Dimension(0, 50));

        //container for name + details
        JPanel infoContainer = new JPanel(new BorderLayout());
        infoContainer.setOpaque(false);

        //laundromatname panel
        JPanel namePanel = new JPanel(new GridLayout(1, 1));
        namePanel.setOpaque(false);
        namePanel.setPreferredSize(new Dimension(200, 30));
        namePanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, 0, 2, UIManager.getColor("listBorder")),
                        BorderFactory.createEmptyBorder(0, 20, 0, 0)
                ));

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(UIManager.getFont("Heading.font"));
        nameLabel.setForeground(UIManager.getColor("foreground"));
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        namePanel.add(nameLabel);

        //details panel for distance + delivery
        JPanel details = new JPanel(new GridLayout(2, 1, 0, 2));
        details.setOpaque(false);
        details.setPreferredSize(new Dimension(200, 60));
        details.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(2, 0, 0, 0, UIManager.getColor("accentColor")),
                        BorderFactory.createEmptyBorder(0, 5, 0, 0)
                )); // left padding, top border

        JLabel distanceLabel = iconCreator.makeImageLabel(
                "Icons/distancefromUser.svg", 15, 15, 5, 5, 0, 0, false
        );
        distanceLabel.setText(distance);
        distanceLabel.setFont(UIManager.getFont("description.Font"));
        distanceLabel.setForeground(UIManager.getColor("foreground"));
        distanceLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel deliveryLabel = iconCreator.makeImageLabel(
                "Icons/deliveryperiod.svg", 15, 15, 0, 5, 5, 0, false
        );
        deliveryLabel.setText(delivery);
        deliveryLabel.setFont(UIManager.getFont("description.Font"));
        deliveryLabel.setForeground(UIManager.getColor("foreground"));
        deliveryLabel.setHorizontalAlignment(SwingConstants.LEFT);

        details.add(distanceLabel);
        details.add(deliveryLabel);

        infoContainer.add(namePanel, BorderLayout.WEST);
        infoContainer.add(details, BorderLayout.CENTER);

        south.add(infoContainer, BorderLayout.CENTER);

        laundryPanel.add(laundromatPicture, BorderLayout.CENTER);
        laundryPanel.add(south, BorderLayout.SOUTH);

        setPanels.laundryPanels(
                BorderFactory.createLineBorder(UIManager.getColor("listBorder"), 2, true),
                UIManager.getColor("background"),
                new Dimension(400, 230),
                laundryPanel
        );

        return laundryPanel;
    }
}

