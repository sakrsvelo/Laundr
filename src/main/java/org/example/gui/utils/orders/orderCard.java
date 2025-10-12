package org.example.gui.utils.orders;

import org.example.gui.utils.creators.buttonCreator;

import javax.swing.*;
import java.awt.*;

public class orderCard extends JPanel {

    public orderCard(String orderId, String weight, String laundromat,
                     String address, String price, String date) {

        // === CARD STYLE ===
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(UIManager.getColor("background"));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0xE5E7EB), 2, true),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));
        setAlignmentX(Component.LEFT_ALIGNMENT);

        // === LEFT COLUMN ===
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setOpaque(false);
        leftPanel.setAlignmentY(Component.TOP_ALIGNMENT);

        JLabel orderInfo = new JLabel("Order " + orderId + " | " + weight);
        JLabel laundromatLabel = new JLabel(laundromat);
        JLabel services = new JLabel("<html><ul style='margin:0;padding-left:15;'>"
                + "<li>Wash and Fold</li>"
                + "<li>Dry Clean</li>"
                + "</ul></html>");

        orderInfo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        laundromatLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        services.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        orderInfo.setForeground(new Color(0x333333));
        laundromatLabel.setForeground(new Color(0x555555));
        services.setForeground(new Color(0x555555));

        // Align all labels to left
        orderInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
        laundromatLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        services.setAlignmentX(Component.LEFT_ALIGNMENT);

        leftPanel.add(orderInfo);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(laundromatLabel);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(services);

        // === MIDDLE COLUMN ===
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        middlePanel.setOpaque(false);
        middlePanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60)); // adjust spacing between columns
        middlePanel.setAlignmentY(Component.TOP_ALIGNMENT);

        JLabel addressLabel = new JLabel("<html>" + address + "</html>");
        JLabel paymentLabel = new JLabel("<html>" + price + "</html>");
        JLabel etaLabel = new JLabel("<html>" + date + "</html>");

        Font midFont = new Font("Segoe UI", Font.PLAIN, 12);
        addressLabel.setFont(midFont);
        paymentLabel.setFont(midFont);
        etaLabel.setFont(midFont);

        addressLabel.setForeground(new Color(0x333333));
        paymentLabel.setForeground(new Color(0x333333));
        etaLabel.setForeground(new Color(0x333333));

        // Align these labels left too
        addressLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        paymentLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        etaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        middlePanel.add(Box.createVerticalStrut(5));
        middlePanel.add(addressLabel);
        middlePanel.add(Box.createVerticalStrut(10));
        middlePanel.add(paymentLabel);
        middlePanel.add(Box.createVerticalStrut(10));
        middlePanel.add(etaLabel);

        // === RIGHT COLUMN ===
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setOpaque(false);
        rightPanel.setAlignmentY(Component.TOP_ALIGNMENT);

        buttonCreator detailsBtn = new buttonCreator("Order Details", "Button.font", () -> {
            System.out.println("Order Details clicked for " + orderId);
        });

        buttonCreator statusBtn = new buttonCreator("Order Status", "Button.font", () -> {
            System.out.println("Order Status clicked for " + orderId);
        });

        detailsBtn.setMaximumSize(new Dimension(130, 60));
        statusBtn.setMaximumSize(new Dimension(130, 60));

        rightPanel.add(Box.createVerticalStrut(5));
        rightPanel.add(detailsBtn);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(statusBtn);

        // === ADD TO CARD ===
        add(leftPanel);
        add(middlePanel);
        add(rightPanel);
    }
}
