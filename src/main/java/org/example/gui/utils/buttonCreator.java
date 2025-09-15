package org.example.gui.utils;

import javax.swing.*;
import java.awt.*;

public class buttonCreator extends JPanel {
    private final JLabel label;

    public buttonCreator(String text, Runnable action) {
        setLayout(new GridBagLayout());
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setOpaque(false);
        setPreferredSize(new Dimension(150, 40));

        label = new JLabel(text);
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
            Font f = UIManager.getFont("Button.font");
            if (f != null) label.setFont(f);
            Color fg = UIManager.getColor("Button.foreground");
            if (fg != null) label.setForeground(fg);
        }

        Color bg = UIManager.getColor("Button.background");
        if (bg != null) setBackground(bg);
        else setBackground(getBackground());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color fill = getBackground();
        if (fill == null) fill = UIManager.getColor("Button.background");
        g2.setColor(fill != null ? fill : new Color(0, 0, 0, 0));
        int arc = UIManager.getInt("Button.arc");
        if (arc <= 0) arc = 16;
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
        g2.dispose();
        super.paintComponent(g);
    }
}
