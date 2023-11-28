package view;

import interface_adapter.createOwnQuestions.CreateOwnQuestionsController;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;
import interface_adapter.takeQuiz.takeQuizState;
import interface_adapter.takeQuiz.takeQuizViewModel;
import interface_adapter.takeQuiz.takeQuizController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class QuizView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewname = "Create Questions";
    private final takeQuizViewModel takeQuizViewModel;
    private final takeQuizController takeQuizController;
    private final JTextPane questionField = new JTextPane();
    private final AnswerButton A1, A2, A3, A4;

    public QuizView(takeQuizViewModel takeQuizViewModel, takeQuizController takeQuizController) {
        this.takeQuizViewModel = takeQuizViewModel;
        this.takeQuizController = takeQuizController;
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
                            }
                        }
                    }
            );
        }
        public void setText(String text) {

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