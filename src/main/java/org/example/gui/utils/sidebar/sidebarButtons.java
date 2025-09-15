package org.example.gui.utils.sidebar;

import javax.swing.*;
import java.awt.*;

public class sidebarButtons extends JPanel {
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

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color fill = getBackground();
        if (fill == null) fill = UIManager.getColor("Button.background");

        int arc = UIManager.getInt("Button.arc");
        if (arc <= 0) arc = 16;

        g2.setColor(fill);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);

        g2.dispose();
        super.paintComponent(g);
    }
}
