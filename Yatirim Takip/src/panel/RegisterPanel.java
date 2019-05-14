package panel;

import components.JNumberField;
import pojo.User;
import statics.Bundle;

import javax.swing.*;
import java.awt.*;

public class RegisterPanel extends JPanel {

    private JLabel nameLabel; private JTextField nameJTextField;
    private JLabel surnameLabel; private JTextField surnameJTextField;
    private JLabel usernameLabel; private JTextField usernameJTextField;
    private JLabel passwordLabel; private JPasswordField passwordJPasswordField;
    private JLabel balanceLabel; private JNumberField balanceJNumberField;
    private JLabel securityQuestionLabel; private JTextField securityQuestionJTextField;
    private JLabel securityAnswerLabel; private JTextField securityAnswerJTextField;

    private JButton registerButton;
    private JButton cancelButton;

    public RegisterPanel() {

        this.nameLabel = new JLabel("Name: ");
        this.surnameLabel = new JLabel("Surname: ");
        this.usernameLabel = new JLabel("Username: ");
        this.passwordLabel = new JLabel("Password: ");
        this.balanceLabel = new JLabel("Balance: ");
        this.securityQuestionLabel = new JLabel("Gizli soru (Şifre unutulunca kullanılacak): ");
        this.securityAnswerLabel = new JLabel("Gizli soru cevabı: ");

        this.nameJTextField = new JTextField();
        this.surnameJTextField = new JTextField();
        this.usernameJTextField = new JTextField();
        this.passwordJPasswordField = new JPasswordField();
        this.balanceJNumberField = new JNumberField();
        this.securityQuestionJTextField = new JTextField();
        this.securityAnswerJTextField = new JTextField();

        this.setLayout(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(0,2));

        registerButton = new JButton(Bundle.REGISTER_BUTTON);
        cancelButton = new JButton(Bundle.CANCEL_BUTTON);
        formPanel.add(new BorderLayoutPanelNorth(nameLabel)); formPanel.add(new BorderLayoutPanelNorth(nameJTextField));
        formPanel.add(new BorderLayoutPanelNorth(surnameLabel)); formPanel.add(new BorderLayoutPanelNorth(surnameJTextField));
        formPanel.add(new BorderLayoutPanelNorth(usernameLabel)); formPanel.add(new BorderLayoutPanelNorth(usernameJTextField));
        formPanel.add(new BorderLayoutPanelNorth(passwordLabel)); formPanel.add(new BorderLayoutPanelNorth(passwordJPasswordField));
        formPanel.add(new BorderLayoutPanelNorth(balanceLabel)); formPanel.add(new BorderLayoutPanelNorth(balanceJNumberField));
        formPanel.add(new BorderLayoutPanelNorth(securityQuestionLabel)); formPanel.add(new BorderLayoutPanelNorth(securityQuestionJTextField));
        formPanel.add(new BorderLayoutPanelNorth(securityAnswerLabel)); formPanel.add(new BorderLayoutPanelNorth(securityAnswerJTextField));

        this.add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(registerButton, FlowLayout.LEFT);
        buttonPanel.add(cancelButton, FlowLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

    }

    public String getName() {
        return nameJTextField.getText().trim();
    }

    public String getSurname() {
        return surnameJTextField.getText().trim();
    }

    public String getUsername() {
        return usernameJTextField.getText().trim();
    }

    public String getPassword() {
        return String.valueOf(this.passwordJPasswordField.getPassword()).trim();
    }

    public double getBalance() {
        return Double.valueOf(this.balanceJNumberField.getText().trim());
    }

    public String getSecurityQuestion() {
        return securityQuestionJTextField.getText().trim();
    }

    public String getSecurityAnswer() {
        return securityAnswerJTextField.getText().trim();
    }

    public boolean validateForm() {
        return !(this.getName() == "" || this.getSurname() == "" || this.getUsername() == ""
                || this.getPassword() == "" || this.getSecurityQuestion() == "" || this.getSecurityAnswer() == "");
    }

    public User getUser() {
        return new User(
                this.getName(),
                this.getSurname(),
                this.getUsername(),
                this.getPassword(),
                this.getBalance(),
                0.0,
                this.getSecurityQuestion(),
                this.getSecurityAnswer()
        );
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}












































