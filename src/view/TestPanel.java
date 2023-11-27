package view;

import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
class TestPanel extends JPanel {
    TestPanel(JLabel name, JLabel comment, JButton edit, JButton play, JButton delete) {
        this.add(name);
        this.add(comment);
        this.add(edit);
        this.add(play);
        this.add(delete);
    }
}
