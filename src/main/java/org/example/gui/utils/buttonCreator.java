package org.example.gui.utils;

import javax.swing.*;
import java.awt.*;

public class buttonCreator extends roundedPanel {
    private final JLabel label;
    private final String fontKey;

    public buttonCreator(String text, String fontKey, Runnable action) {
        this.fontKey = fontKey;

        setLayout(new GridBagLayout());
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setOpaque(false);

        // Fixed height = 40, flexible width
        setPreferredSize(new Dimension(150, 40));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        label = new JLabel(text, SwingConstants.CENTER);
        add(label);

        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                action.run();
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                Color hover = UIManager.getColor("Button.hoverBackground");
                if (hover != null) setBackground(hover);
                repaint();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                Color bg = UIManager.getColor("Button.background");
                if (bg != null) setBackground(bg);
                repaint();
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                Color pressed = UIManager.getColor("Button.pressedBackground");
                if (pressed != null) setBackground(pressed);
                repaint();
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                Color bg = UIManager.getColor("Button.background");
                if (bg != null) setBackground(bg);
                repaint();
            }
        });

        updateUI();
    }

    @Override
    public void updateUI() {
        super.updateUI();

        if (label != null) {
            Font f = UIManager.getFont(fontKey); // Choose font by key
            if (f != null) label.setFont(f);
            Color fg = UIManager.getColor("Button.foreground");
            if (fg != null) label.setForeground(fg);
        }

        Color bg = UIManager.getColor("Button.background");
        if (bg != null) setBackground(bg);
    }
}
