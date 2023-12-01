package view;

import interface_adapter.takeQuiz.takeQuizState;
import interface_adapter.takeQuiz.takeQuizViewModel;
import interface_adapter.takeQuiz.takeQuizController;
import interface_adapter.getResult.GetResultController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class QuizView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewname = "Take Quiz";
    private final takeQuizViewModel takeQuizViewModel;
    private final takeQuizController takeQuizController;
    private final GetResultController getResultController;
    private final JLabel questionField = new JLabel();
    private final AnswerButton A1, A2, A3, A4;

    public QuizView(takeQuizViewModel takeQuizViewModel, takeQuizController takeQuizController, GetResultController getResultController) {
        this.takeQuizViewModel = takeQuizViewModel;
        this.takeQuizController = takeQuizController;
        this.getResultController = getResultController;

        this.takeQuizViewModel.addPropertyChangeListener(this);
        this.add(questionField);
        this.A1 = new AnswerButton(new JButton("answer 1"), 0);
        this.add(A1);
        this.A2 = new AnswerButton(new JButton("answer 2"), 1);
        this.add(A2);
        this.A3 = new AnswerButton(new JButton("answer 3"), 2);
        this.add(A3);
        this.A4 = new AnswerButton(new JButton("answer 4"), 3);
        this.add(A4);
    }

    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        takeQuizState state = (takeQuizState) evt.getNewValue();

        questionField.setText(state.getQuestion());
        A1.setText(state.getAnswer(0));
        A2.setText(state.getAnswer(1));

        if (state.getAnswerCount() == 4) {
            A3.setText(state.getAnswer(2));
            A4.setText(state.getAnswer(3));
            A3.setVisible(true);
            A4.setVisible(true);
        } else {
            A3.setVisible(false);
            A4.setVisible(false);
        }
        //this.repaint();
    }

    private class AnswerButton extends JPanel {
        private final JButton button;
        AnswerButton(JButton b, int i) {
            this.button = b;
            this.add(this.button);
            button.addActionListener(
                    // This creates an anonymous subclass of ActionListener and instantiates it.
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(button)) {
                                takeQuizState currentState = takeQuizViewModel.getState();
                                takeQuizController.answerQuestion(currentState.getAnswer(i));
                                currentState = takeQuizViewModel.getState();
                                if (currentState.isFinished()) {
                                    getResultController.execute(currentState.getTestName());
                                }
                            }
                        }
                    }
            );
        }
        public void setText(String text) {
            button.setText(text);
        }
        public JButton getButton() {
            return button;
        }
    }
}

//{"name":"name", "category":"General","comment":"yep", "questions":[
//  {"text": "yep", "correctAnswer":"true", "wrongAnswers":["false"]}
// ],
// "results":[{"date":978132901297,"comment":"yep", [true, false, true]}
// ]}