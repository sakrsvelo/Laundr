package org.example.gui.utils;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;

public class iconFactory {
    public static Icon getIcon(String path, int w, int h) {
        try {
            return new FlatSVGIcon(path, w, h);
        } catch (Exception e) {
            e.printStackTrace();
            return UIManager.getIcon("OptionPane.informationIcon");
        }
    }
}
