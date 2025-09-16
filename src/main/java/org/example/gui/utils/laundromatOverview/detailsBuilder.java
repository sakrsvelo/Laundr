package org.example.gui.utils.laundromatOverview;

import org.example.gui.utils.reviewSectionBuilder;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class detailsBuilder {
    private String name;
    private String address;
    private String distance;
    private String deliveryTime;
    private Icon logoIcon;
    private Icon addressIcon;
    private Icon distanceIcon;
    private Icon deliveryIcon;

    private int width = 740;
    private int height = 660;
    private Color bgColor = UIManager.getColor("background");

    //================ Setters ==================
    public detailsBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public detailsBuilder setAddress(String address) {
        this.address = address;
        return this;
    }
    public detailsBuilder setDistance(String distance) {
        this.distance = distance;
        return this;
    }
    public detailsBuilder setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
        return this;
    }
    public detailsBuilder setLogoIcon(Icon logoIcon) {
        this.logoIcon = logoIcon;
        return this;
    }
    public detailsBuilder setAddressIcon(Icon addressIcon) {
        this.addressIcon = addressIcon;
        return this;
    }
    public detailsBuilder setDistanceIcon(Icon distanceIcon) {
        this.distanceIcon = distanceIcon;
        return this;
    }
    public detailsBuilder setDeliveryIcon(Icon deliveryIcon) {
        this.deliveryIcon = deliveryIcon;
        return this;
    }
    public detailsBuilder setSize(int width, int height) {
        this.width = width; this.height = height;
        return this;
    }

    public JPanel build() {
        JPanel laundryDetails = new JPanel(new BorderLayout(0, 5));
        laundryDetails.setBackground(bgColor);
        laundryDetails.setBorder(BorderFactory.createLineBorder(UIManager.getColor("listBorder"), 3, true));
        laundryDetails.setPreferredSize(new Dimension(width, height));

        //================ Overview ==================
        JPanel overviewPanel = new overviewBuilder()
                .setName(name)
                .setAddress(address)
                .setDistance(distance)
                .setDeliveryTime(deliveryTime)
                .setLogoIcon(logoIcon)
                .setAddressIcon(addressIcon)
                .setDistanceIcon(distanceIcon)
                .setDeliveryIcon(deliveryIcon)
                .build();

        laundryDetails.add(overviewPanel, BorderLayout.NORTH);

        //================ Center Panels ==================
        JPanel detailsCenter = new JPanel(new BorderLayout());
        detailsCenter.setPreferredSize(new Dimension(width - 40, height));
        detailsCenter.setOpaque(false);
        detailsCenter.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(2, 0, 0, 0, UIManager.getColor("listBorder")),
                        BorderFactory.createEmptyBorder(0, 20, 20, 20)
                ));

        //================ Left: Offerings & Services ==================
        JPanel detailsWest = new JPanel(new BorderLayout());
        detailsWest.setOpaque(false);
        detailsWest.setPreferredSize(new Dimension(450, 490));

        JPanel laundromatOfferings = new JPanel(new BorderLayout());
        laundromatOfferings.setOpaque(false);
        laundromatOfferings.setPreferredSize(new Dimension(0, 350));

        JPanel offeringsLabelPanel = new JPanel(new BorderLayout());
        offeringsLabelPanel.setOpaque(false);
        offeringsLabelPanel.setPreferredSize(new Dimension(0, 50));

        JLabel offeringsLabel = new JLabel("What We Offer:");
        offeringsLabel.setFont(UIManager.getFont("Heading.font"));
        offeringsLabel.setForeground(UIManager.getColor("foreground"));
        offeringsLabelPanel.add(offeringsLabel, BorderLayout.WEST);

        JPanel offeringsList = new JPanel();
        offeringsList.setLayout(new BoxLayout(offeringsList, BoxLayout.Y_AXIS));
        offeringsList.setOpaque(false);
        offeringsList.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(2, 2, 2, 2, UIManager.getColor("listBorder")),
                        BorderFactory.createEmptyBorder(20, 20, 20, 20)
                ));

        String[] offerings = {
                "24/7 Service",
                "Express Delivery",
                "Wash, Dry & Fold",
                "Pickup & Drop-off"
        };

        for (String offering : offerings) {
            JLabel bulletLabel = new JLabel("• " + offering);
            bulletLabel.setFont(UIManager.getFont("defaultFont"));
            bulletLabel.setForeground(UIManager.getColor("foreground"));
            bulletLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            offeringsList.add(bulletLabel);
            offeringsList.add(Box.createVerticalStrut(10));
        }

        laundromatOfferings.add(offeringsLabelPanel, BorderLayout.NORTH);
        laundromatOfferings.add(offeringsList, BorderLayout.CENTER);

        JPanel servicesSection = serviceBuilder.buildServicesSection();

        detailsWest.add(laundromatOfferings, BorderLayout.NORTH);
        detailsWest.add(servicesSection, BorderLayout.SOUTH);

        JPanel detailsEast = new JPanel(new BorderLayout());
        detailsEast.setOpaque(false);
        detailsEast.setPreferredSize(new Dimension(220, 100));

        ArrayList<String> users = new ArrayList<>();
        users.add("John Doe");
        users.add("Jane Doe");
        users.add("John Q. Public");

        ArrayList<String> reviews = new ArrayList<>();
        reviews.add("Great service! Will definitely come back.");
        reviews.add("Fast delivery and very clean laundry.");
        reviews.add("Reliable and friendly staff.");

        Icon userIcon = new FlatSVGIcon(
                "Icons/userIconBlue.svg",35, 35);

        JPanel reviewsSection = reviewSectionBuilder.buildReviewsSection(users, reviews, userIcon);

        JPanel nextButton = new JPanel(new BorderLayout());
        nextButton.setBackground(UIManager.getColor("Button.background"));
        nextButton.setPreferredSize(new Dimension(Integer.MAX_VALUE, 50));

        JLabel reqPickup = new JLabel("Request Pickup");
        reqPickup.setFont(UIManager.getFont("Title.font"));
        reqPickup.setForeground(UIManager.getColor("Button.foreground"));
        reqPickup.setHorizontalTextPosition(SwingConstants.CENTER);
        reqPickup.setVerticalTextPosition(SwingConstants.CENTER);
        reqPickup.setHorizontalAlignment(SwingConstants.CENTER);

        nextButton.add(reqPickup, BorderLayout.CENTER);

        detailsEast.add(reviewsSection, BorderLayout.NORTH);
        detailsEast.add(nextButton, BorderLayout.SOUTH);

        detailsCenter.add(detailsWest, BorderLayout.WEST);
        detailsCenter.add(detailsEast, BorderLayout.EAST);

        laundryDetails.add(detailsCenter, BorderLayout.CENTER);

        return laundryDetails;
    }
}
