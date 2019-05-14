package frame;

import implementation.TimeDepositDaoImplementation;
import panel.NewTimeDepositPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewTimeDepositFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private NewTimeDepositPanel newTimeDepositPanel;

    public NewTimeDepositFrame() throws HeadlessException {
        super();

        this.setTitle("new Time Deposit");
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        newTimeDepositPanel = new NewTimeDepositPanel();
        this.add(newTimeDepositPanel);

        newTimeDepositPanel.getAddNewButton().addActionListener(this);
        newTimeDepositPanel.getCancelButton().addActionListener(this);

        this.invalidate();
        this.validate();
        this.repaint();
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(newTimeDepositPanel.getAddNewButton().getActionCommand())) {
            new TimeDepositDaoImplementation().save(this.newTimeDepositPanel.getTimeDeposit());
            dispose();
            RootFrame rootFrame = new RootFrame();
            rootFrame.setVisible(true);
        } else if (e.getActionCommand().equals(newTimeDepositPanel.getCancelButton().getActionCommand())) {
            dispose();
        }
    }
}
