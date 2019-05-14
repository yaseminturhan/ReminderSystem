package panel;

import components.ListJTable;
import frame.NewTimeDepositFrame;
import implementation.TimeDepositDaoImplementation;
import statics.Bundle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeDepositPanel extends JPanel implements ActionListener {

    private JButton addNewButton;
    private TimeDepositDaoImplementation timeDepositDaoImplementation;
    private ListJTable timeDepositTable;

    public TimeDepositPanel() {
        super();
        this.setLayout(new BorderLayout());

        timeDepositDaoImplementation = new TimeDepositDaoImplementation();

        addNewButton = new JButton(Bundle.ADD_NEW_TIME_DEPOSIT);

        timeDepositTable = new ListJTable(timeDepositDaoImplementation.getAllForTable(),
                timeDepositDaoImplementation.getColumnsForTable());

        JScrollPane scrollPane = new JScrollPane(timeDepositTable);

        // CENTER
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        //
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel newButtonStockPanel = new JPanel();

        newButtonStockPanel.add(addNewButton);
        bottomPanel.add(new BorderLayoutPanelNorth(newButtonStockPanel), BorderLayout.EAST);

        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        addNewButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Bundle.ADD_NEW_TIME_DEPOSIT)) {
            NewTimeDepositFrame newTimeDepositPanel = new NewTimeDepositFrame();
            newTimeDepositPanel.setVisible(true);
        }
    }
}
