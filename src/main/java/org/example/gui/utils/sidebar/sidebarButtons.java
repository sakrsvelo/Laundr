package org.example.gui.utils.sidebar;

import org.example.gui.utils.roundedPanel;

import javax.swing.*;
import java.awt.*;

public class sidebarButtons extends roundedPanel {
    private final JLabel label;
    private static final int BUTTON_WIDTH = 180;
    private static final int BUTTON_HEIGHT = 40;

    public sidebarButtons(String text, Icon icon, Runnable action) {
        setLayout(new GridBagLayout());
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setOpaque(false);

        // Fixed size
        setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        setMinimumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

        // Center alignment for BoxLayout parent
        setAlignmentX(Component.CENTER_ALIGNMENT);

        // Label inside button
        label = new JLabel(text, icon, SwingConstants.LEFT);
        label.setIconTextGap(12);
        add(label);

        // Mouse interactions
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                action.run();
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                setBackground(UIManager.getColor("Sidebar.hoverBackground"));
                repaint();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                setBackground(UIManager.getColor("Button.background"));
                repaint();
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                setBackground(UIManager.getColor("Button.pressedBackground"));
                repaint();
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                setBackground(UIManager.getColor("Button.background"));
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
}
