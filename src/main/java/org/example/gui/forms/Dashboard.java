package org.example.gui.forms;

import javax.swing.*;

import org.example.gui.utils.laundromatOverview.detailsBuilder;
import org.example.gui.utils.laundrylist.laundromatListBuilder;
import org.example.gui.utils.setPanels;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import java.awt.*;

public class Dashboard extends JPanel {
    public Dashboard (){
        //=========== ICONS ==========
        Icon logo = new FlatSVGIcon("Icons/laundromatLogo.svg", 70, 70);
        Icon addressIcon = new FlatSVGIcon("Icons/address.svg", 20, 20);
        Icon distanceIcon = new FlatSVGIcon("Icons/distancefromUser.svg", 20, 20);
        Icon deliveryIcon = new FlatSVGIcon("Icons/deliveryperiod.svg", 20, 20);

        //=========== LAUNDRY LIST ==========
        JPanel laundryList = laundromatListBuilder.createLaundromatList();

        //=========== LAUNDRY DETAILS ==========
        JPanel laundryDetails = new detailsBuilder()
                .setName("Real Laundromat")
                .setAddress("456 Clean St., Davao City")
                .setDistance("1.2 kilometers away")
                .setDeliveryTime("2~4 days")
                .setLogoIcon(logo)
                .setAddressIcon(addressIcon)
                .setDistanceIcon(distanceIcon)
                .setDeliveryIcon(deliveryIcon)
                .setSize(740, 660)
                .build();

        //=========== WRAPPING & LAYOUT ==========
        JPanel laundrydetailsContainer = new JPanel(new BorderLayout());
        laundrydetailsContainer.add(laundryDetails, BorderLayout.CENTER);

        JPanel content = new JPanel(new BorderLayout());
        JPanel horizontalContent = new JPanel();
        horizontalContent.setLayout(new BoxLayout(horizontalContent, BoxLayout.X_AXIS));
        horizontalContent.setOpaque(false);
        horizontalContent.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        horizontalContent.add(laundryList);
        horizontalContent.add(Box.createRigidArea(new Dimension(20, 0)));
        horizontalContent.add(laundrydetailsContainer);

        content.setLayout(new BorderLayout());
        content.add(horizontalContent, BorderLayout.CENTER);

        add(content, BorderLayout.CENTER);
    }
}
