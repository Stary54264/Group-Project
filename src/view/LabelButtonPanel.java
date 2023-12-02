package view;

import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
class LabelButtonPanel extends JPanel {
    private final JLabel label;
    private final JButton button;
    LabelButtonPanel(JLabel label, JButton button) {
        this.button = button;
        this.label = label;
        this.add(this.label);
        this.add(this.button);
    }
}
