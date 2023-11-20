package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class QuizView implements ActionListener, PropertyChangeListener {

    public final String viewname = "Create Questions";
    private final CreateOwnQuestionsViewModel createOwnQuestionsViewModel;
    private final JTextField questionField = new JTextField();
    private final JTextField answerField = new JTextField();
    private final JList<String> incorrectList = new JList<String>();
    private final CreateOwnQuestionsController createOwnQuestionsController;
    private final JButton createQuestions;
    private final JButton cancel;
    
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
