package org.example.gui.utils.sidebar;

import org.example.gui.utils.creators.roundedPanel;

import javax.swing.*;
import java.awt.*;

public class sidebarButtons extends roundedPanel {
    private final JLabel label;
    private static final int BUTTON_WIDTH = 180;
    private static final int BUTTON_HEIGHT = 40;
    private static sidebarButtons activeButton;

    public sidebarButtons(String text, Icon icon, Runnable action) {
        setLayout(new GridBagLayout());
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setOpaque(false);

        setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        setMinimumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        label = new JLabel(text, icon, SwingConstants.LEFT);
        label.setIconTextGap(12);

        addAlignedLabel(label);

        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                setActive();
                action.run();
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (sidebarButtons.this != activeButton) {
                    setBackground(UIManager.getColor("Sidebar.hoverBackground"));
                    repaint();
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                if (sidebarButtons.this != activeButton) {
                    setBackground(UIManager.getColor("Sidebarbtn.background"));
                    repaint();
                }
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                setBackground(UIManager.getColor("Button.pressedBackground"));
                repaint();
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                if (sidebarButtons.this != activeButton) {
                    setBackground(UIManager.getColor("Sidebarbtn.background"));
                }
                repaint();
            }
        });

        updateUI();
    }

    private void addAlignedLabel(JLabel lbl) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 12, 0, 0);
        gbc.weightx = 1; // allows expansion
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(lbl, gbc);
    }

    private void setActive() {
        if (activeButton != null && activeButton != this) {
            activeButton.setBackground(UIManager.getColor("Sidebarbtn.background"));
            activeButton.repaint();
        }
        activeButton = this;
        setBackground(UIManager.getColor("Button.pressedBackground"));
        repaint();
    }

    public static void setDefaultActive(sidebarButtons button) {
        if (activeButton != null && activeButton != button) {
            activeButton.setBackground(UIManager.getColor("Sidebarbtn.background"));
            activeButton.repaint();
        }
        activeButton = button;
        button.setBackground(UIManager.getColor("Button.pressedBackground"));
        button.repaint();
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

        if (this == activeButton) {
            setBackground(UIManager.getColor("Button.pressedBackground"));
        } else {
            Color bg = UIManager.getColor("Sidebarbtn.background");
            if (bg != null) setBackground(bg);
        }
    }
}
