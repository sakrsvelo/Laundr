package org.example.gui.utils.laundromatOverview;

import javax.swing.*;
import java.awt.*;

public class overviewBuilder {

    private String name = "";
    private String address = "";
    private String distance = "";
    private String deliveryTime = "";
    private Icon logoIcon = null;
    private Icon addressIcon = null;
    private Icon distanceIcon = null;
    private Icon deliveryIcon = null;

    private Color mainTextColor = new Color(0x273755);
    private Font nameFont = new Font("Fredoka", Font.BOLD, 28);
    private Font infoFont = new Font("Fredoka", Font.PLAIN, 14);

    public overviewBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public overviewBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public overviewBuilder setDistance(String distance) {
        this.distance = distance;
        return this;
    }

    public overviewBuilder setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
        return this;
    }

    public overviewBuilder setLogoIcon(Icon logoIcon) {
        this.logoIcon = logoIcon;
        return this;
    }

    public overviewBuilder setAddressIcon(Icon addressIcon) {
        this.addressIcon = addressIcon;
        return this;
    }

    public overviewBuilder setDistanceIcon(Icon distanceIcon) {
        this.distanceIcon = distanceIcon;
        return this;
    }

    public overviewBuilder setDeliveryIcon(Icon deliveryIcon) {
        this.deliveryIcon = deliveryIcon;
        return this;
    }

    public JPanel build() {
        JPanel laundromatOverview = new JPanel(new BorderLayout());
        laundromatOverview.setOpaque(false);
        laundromatOverview.setPreferredSize(new Dimension(700, 100));
        laundromatOverview.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        if (logoIcon != null) {
            JLabel laundromatLogo = new JLabel(logoIcon);
            laundromatOverview.add(laundromatLogo, BorderLayout.WEST);
        }

        JPanel nameAddressPanel = new JPanel();
        nameAddressPanel.setLayout(new BoxLayout(nameAddressPanel, BoxLayout.Y_AXIS));
        nameAddressPanel.setOpaque(false);

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(nameFont);
        nameLabel.setForeground(mainTextColor);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        nameLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 0));

        JLabel addressLabel;
        if (addressIcon != null) {
            addressLabel = new JLabel(address, addressIcon, SwingConstants.LEFT);
        } else {
            addressLabel = new JLabel(address);
        }
        addressLabel.setFont(infoFont);
        addressLabel.setForeground(mainTextColor);
        addressLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        addressLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 0));

        nameAddressPanel.add(nameLabel);
        nameAddressPanel.add(addressLabel);

        // Distance & Delivery Panel
        JPanel distanceDeliveryPanel = new JPanel();
        distanceDeliveryPanel.setLayout(new BoxLayout(distanceDeliveryPanel, BoxLayout.Y_AXIS));
        distanceDeliveryPanel.setOpaque(false);
        distanceDeliveryPanel.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, new Color(0x31A4E5)));

        JLabel distanceLabel;
        if (distanceIcon != null) {
            distanceLabel = new JLabel(distance, distanceIcon, SwingConstants.LEFT);
        } else {
            distanceLabel = new JLabel(distance);
        }
        distanceLabel.setFont(infoFont);
        distanceLabel.setForeground(mainTextColor);
        distanceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        distanceLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 0));

        JLabel deliveryLabel;
        if (deliveryIcon != null) {
            deliveryLabel = new JLabel(deliveryTime, deliveryIcon, SwingConstants.LEFT);
        } else {
            deliveryLabel = new JLabel(deliveryTime);
        }
        deliveryLabel.setFont(infoFont);
        deliveryLabel.setForeground(mainTextColor);
        deliveryLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        deliveryLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 0));

        distanceDeliveryPanel.add(distanceLabel);
        distanceDeliveryPanel.add(deliveryLabel);

        JPanel infoWrapper = new JPanel();
        infoWrapper.setLayout(new BoxLayout(infoWrapper, BoxLayout.X_AXIS));
        infoWrapper.setOpaque(false);
        infoWrapper.add(nameAddressPanel);
        infoWrapper.add(Box.createRigidArea(new Dimension(20, 0)));
        infoWrapper.add(distanceDeliveryPanel);

        laundromatOverview.add(infoWrapper, BorderLayout.CENTER);

        return laundromatOverview;
    }
}
