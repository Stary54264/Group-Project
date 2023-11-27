package view;
import interface_adapter.getResult.GetResultState;
import interface_adapter.getResult.GetResultViewModel;
import view.LabelTextPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GetResultView extends JPanel implements ActionListener, PropertyChangeListener{
    private final GetResultViewModel getResultViewModel;
    JLabel result;
    final JButton getResult;

    public GetResultView(GetResultViewModel getResultViewModel) {
        this.getResultViewModel = getResultViewModel;
        this.result = new JLabel();
        this.getResult = new JButton("Get Result");
        this.getResult.addActionListener(this);
        this.add(result);
        this.add(getResult);
        this.getResultViewModel.addPropertyChangeListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {System.out.println("Click " + evt.getActionCommand());}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
