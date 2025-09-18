package org.example.gui.utils;

import javax.swing.*;
import java.awt.*;

public class roundedPanel extends JPanel {
    private int arc;

    public roundedPanel() {
        this.arc = UIManager.getInt("Button.arc");
        if (arc <= 0) arc = 16;
        setOpaque(false);
    }

    public roundedPanel(int arc) {
        this.arc = arc;
        setOpaque(false);
    }

    public void setArc(int arc) {
        this.arc = arc;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color fill = getBackground();
        if (fill == null) fill = UIManager.getColor("Panel.background");
        g2.setColor(fill != null ? fill : new Color(0, 0, 0, 0));

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);

        g2.dispose();
        super.paintComponent(g);
    }
}
