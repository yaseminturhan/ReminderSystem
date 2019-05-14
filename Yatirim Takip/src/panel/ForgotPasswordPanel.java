package panel;

import implementation.UserDaoImplementation;
import statics.Bundle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ForgotPasswordPanel extends JPanel implements KeyListener {

    private JLabel usernameLabel;
    private JLabel securityQuestionLabel;
    private JLabel securityAnswerLabel;
    private JTextField usernameJTextField;
    private JTextField securityQuestionJTextField;
    private JTextField securityAnswerJTextField;

    private JButton showMePasswordButton;

    public ForgotPasswordPanel() {
        this.usernameLabel = new JLabel("Username: ");
        this.usernameJTextField = new JTextField();
        this.securityQuestionLabel = new JLabel("Secure question: ");
        this.securityQuestionJTextField = new JTextField();
        this.securityAnswerLabel = new JLabel("Answer:");
        this.securityAnswerJTextField = new JTextField();

        showMePasswordButton = new JButton(Bundle.SHOW_ME_PASSWORD);

        this.setLayout(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(0,2));

        formPanel.add(new BorderLayoutPanelNorth(usernameLabel)); formPanel.add(new BorderLayoutPanelNorth(usernameJTextField));
        formPanel.add(new BorderLayoutPanelNorth(securityQuestionLabel)); formPanel.add(new BorderLayoutPanelNorth(securityQuestionJTextField));
        formPanel.add(new BorderLayoutPanelNorth(securityAnswerLabel)); formPanel.add(new BorderLayoutPanelNorth(securityAnswerJTextField));

        this.add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(showMePasswordButton, FlowLayout.LEFT);
        this.add(buttonPanel, BorderLayout.SOUTH);

        usernameJTextField.addKeyListener(this);
    }

    public String getUsername() {
        return usernameJTextField.getText().trim();
    }

    public String getSecurityQuestion() {
        return securityQuestionJTextField.getText().trim();
    }

    public String getSecurityAnswer() {
        return securityAnswerJTextField.getText().trim();
    }

    public String getPassword() {
        return new UserDaoImplementation().findPassword(this.getUsername(), this.getSecurityQuestion(), this.getSecurityAnswer());
    }

    public JButton getShowMePasswordButton() {
        return showMePasswordButton;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.securityQuestionJTextField.setText(new UserDaoImplementation().findSecurityQuestion(this.getUsername()));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

}
