package view;
import interface_adapter.ViewManagerModel;
import interface_adapter.getResult.GetResultViewModel;
import interface_adapter.manageQuiz.manageQuizViewModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GetResultView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewname = "getResult";
    private final JLabel resultLabel;
    private final JButton backButton;
    private final GetResultViewModel getResultViewModel;
    private final ViewManagerModel viewManagerModel;
    private final interface_adapter.manageQuiz.manageQuizViewModel manageQuizViewModel;

    public GetResultView(GetResultViewModel getResultViewModel, ViewManagerModel viewManagerModel, manageQuizViewModel manageQuizViewModel) {
        this.getResultViewModel = getResultViewModel;
        this.viewManagerModel = viewManagerModel;
        this.manageQuizViewModel = manageQuizViewModel;

        resultLabel = new JLabel("Result: ");
        backButton = new JButton("Back");

        backButton.addActionListener(this);

        this.getResultViewModel.addPropertyChangeListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(resultLabel);
        this.add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            viewManagerModel.setActiveView(manageQuizViewModel.getViewName());
            manageQuizViewModel.firePropertyChanged();
            viewManagerModel.firePropertyChanged();
        }
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            resultLabel.setText("Result: " + getResultViewModel.result());
        }
    }
}