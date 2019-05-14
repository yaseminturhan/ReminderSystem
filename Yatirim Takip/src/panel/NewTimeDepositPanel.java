package panel;

import components.JNumberField;
import constant.InterestPeriod;
import pojo.TimeDeposit;
import statics.Bundle;
import statics.Global;

import javax.swing.*;
import java.awt.*;

public class NewTimeDepositPanel extends JPanel {

    private JLabel balanceLabel; private JNumberField balanceJNumberField;
    private JLabel interestRateLabel; private JNumberField interestRateJNumberField;
    private JLabel interestPeriodLabel; private JComboBox interestPeriodComboBox;

    private JButton addNewButton;
    private JButton cancelButton;

    public NewTimeDepositPanel() {
        super();

        balanceLabel = new JLabel("Balance: "); balanceJNumberField = new JNumberField();
        interestRateLabel = new JLabel("Interest Rate: "); interestRateJNumberField = new JNumberField();
        interestPeriodLabel = new JLabel("Interest Period: "); interestPeriodComboBox = new JComboBox<>();

        addNewButton = new JButton(Bundle.ADD_NEW_TIME_DEPOSIT);
        cancelButton = new JButton(Bundle.CANCEL_BUTTON);

        interestPeriodComboBox.setModel(new DefaultComboBoxModel<>(InterestPeriod.values()));

        this.setLayout(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(0,2));

        formPanel.add(new BorderLayoutPanelNorth(balanceLabel)); formPanel.add(new BorderLayoutPanelNorth(balanceJNumberField));
        formPanel.add(new BorderLayoutPanelNorth(interestRateLabel)); formPanel.add(new BorderLayoutPanelNorth(interestRateJNumberField));
        formPanel.add(new BorderLayoutPanelNorth(interestPeriodLabel)); formPanel.add(new BorderLayoutPanelNorth(interestPeriodComboBox));

        this.add(formPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addNewButton, FlowLayout.LEFT);
        buttonPanel.add(cancelButton, FlowLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

    }

    public double getBalance() {
        return Double.valueOf(balanceJNumberField.getText().trim());
    }

    public double getInterestRate() {
        return Double.valueOf(interestRateJNumberField.getText().trim());
    }

    public InterestPeriod getInterestPeriod() {
        return
                interestPeriodComboBox.getSelectedItem().toString().trim().equals("DAILY") ? InterestPeriod.DAILY :
                        interestPeriodComboBox.getSelectedItem().toString().trim().equals("MONTHLY") ? InterestPeriod.MONTHLY :
                InterestPeriod.ANNUAL;
    }

    public JButton getAddNewButton() {
        return addNewButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public TimeDeposit getTimeDeposit() {
            return new TimeDeposit(
                    getBalance(),
                    getInterestRate(),
                    getInterestPeriod(),
                    Global.user.getUsername()
            );
    }
}

















