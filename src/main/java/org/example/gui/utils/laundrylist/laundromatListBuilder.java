package org.example.gui.utils.laundrylist;

import org.example.gui.utils.makeWrapper;

import javax.swing.*;
import java.awt.*;

public class laundromatListBuilder {

    public static JPanel createLaundromatList() {
        JPanel laundryList = new JPanel();
        laundryList.setBackground(new Color(0xF8FBFD));
        laundryList.setBorder(BorderFactory.createLineBorder(new Color(0x31A4E5), 3, true));
        laundryList.setPreferredSize(new Dimension(440, 720));
        laundryList.setLayout(new BoxLayout(laundryList, BoxLayout.Y_AXIS));

        JPanel laundry1 = laundromatPanels.createLaundryPanel("Real Laundromat Place", "1.2 kilometers away", "2~4 days", "Pictures/laundromat1.svg");
        JPanel laundry2 = laundromatPanels.createLaundryPanel("Existing Laundromat", "850 meters away", "1~2 days", "Pictures/laundromat2.svg");
        JPanel laundry3 = laundromatPanels.createLaundryPanel("Actual Laundromat", "2.5 kilometers away", "3~5 days", "Pictures/laundromat3.svg");

        laundryList.add(Box.createVerticalStrut(20));
        laundryList.add(makeWrapper.wrapCenter(laundry1));
        laundryList.add(Box.createVerticalStrut(-10));
        laundryList.add(makeWrapper.wrapCenter(laundry2));
        laundryList.add(Box.createVerticalStrut(-10));
        laundryList.add(makeWrapper.wrapCenter(laundry3));

        return laundryList;
    }
}

