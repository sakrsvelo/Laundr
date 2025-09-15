package org.example.gui.utils;

import javax.swing.*;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import java.awt.*;

public class iconCreator {

    public static JLabel makeImageLabel(String path, int width, int height, int top, int left, int bottom, int right, boolean clickable) {
    FlatSVGIcon icon = new FlatSVGIcon(path);
    Image scaled = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    JLabel label = new JLabel(new ImageIcon(scaled));

    if (top + left + bottom + right > 0) {
        label.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
    }
    if (clickable) {
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    return label;

    }

}
