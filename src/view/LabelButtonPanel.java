package view;

import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
class LabelButtonPanel extends JPanel {
    LabelButtonPanel(JLabel label, JButton button) {
        this.add(label);
        this.add(button);
    }
}
