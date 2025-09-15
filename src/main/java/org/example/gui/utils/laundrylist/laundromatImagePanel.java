package org.example.gui.utils.laundrylist;

import javax.swing.*;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import java.awt.*;

public class laundromatImagePanel extends JPanel {
    private final FlatSVGIcon svgIcon;

    public laundromatImagePanel(String imagePath) {
        this.svgIcon = new FlatSVGIcon(imagePath);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (svgIcon != null) {
            svgIcon.paintIcon(this, g, 0, 0);
        }
    }
}
