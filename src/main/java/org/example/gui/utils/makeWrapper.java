package org.example.gui.utils;
import javax.swing.*;
import java.awt.*;

public class makeWrapper {

    public static JPanel wrapCenter(JPanel panel) {
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        wrapper.setOpaque(false);
        wrapper.add(panel);
        return wrapper;
    }
}
