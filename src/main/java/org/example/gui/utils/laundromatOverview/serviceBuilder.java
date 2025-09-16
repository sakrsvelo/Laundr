package org.example.gui.utils.laundromatOverview;

import org.example.gui.utils.setPanels;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import java.awt.*;

public class serviceBuilder {
    public static JPanel buildServicesSection() {
        JPanel laundromatServices = new JPanel(new BorderLayout());
        laundromatServices.setOpaque(false);
        laundromatServices.setPreferredSize(new Dimension(0, 240));

        JPanel servicesLabelPanel = new JPanel(new BorderLayout());
        servicesLabelPanel.setOpaque(false);
        servicesLabelPanel.setPreferredSize(new Dimension(0, 45));

        JLabel servicesLabel = new JLabel("Services:");
        servicesLabel.setFont(UIManager.getFont("Heading.font"));
        servicesLabel.setForeground(UIManager.getColor("foreground"));
        servicesLabelPanel.add(servicesLabel, BorderLayout.WEST);

        JPanel servicesPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        servicesPanel.setOpaque(false);

        Icon washIcon = new FlatSVGIcon("Icons/washandFold.svg", 60, 70);
        Icon dryIcon = new FlatSVGIcon("Icons/dryClean.svg", 60, 70);
        Icon ironIcon = new FlatSVGIcon("Icons/iron.svg", 60, 70);

        //example service panels
        JPanel wash = setPanels.servicePanel(
                "Wash and Fold",
                washIcon,
                BorderFactory.createLineBorder(UIManager.getColor("listBorder"), 2, true),
                UIManager.getColor("background"),
                new Dimension(150, 70)
        );

        JPanel dry = setPanels.servicePanel(
                "Dry Clean",
                dryIcon,
                BorderFactory.createLineBorder(UIManager.getColor("listBorder"), 2, true),
                UIManager.getColor("background"),
                new Dimension(150, 70)
        );

        JPanel iron = setPanels.servicePanel(
                "Iron",
                ironIcon,
                BorderFactory.createLineBorder(UIManager.getColor("listBorder"), 2, true),
                UIManager.getColor("background"),
                new Dimension(150, 70)
        );

        servicesPanel.add(wash);
        servicesPanel.add(dry);
        servicesPanel.add(iron);

        laundromatServices.add(servicesLabelPanel, BorderLayout.NORTH);
        laundromatServices.add(servicesPanel, BorderLayout.CENTER);

        return laundromatServices;
    }
}
