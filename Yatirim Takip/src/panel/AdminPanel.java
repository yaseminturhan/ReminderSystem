package panel;

import components.JNumberField;
import components.ListJTable;
import implementation.UserDaoImplementation;
import pojo.User;
import statics.Bundle;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class AdminPanel extends JPanel implements ListSelectionListener, ActionListener {

    private JButton updateButton;
    private JButton deleteButton;
    private UserDaoImplementation userDaoImplementation;
    private ListJTable userTable;

    private JLabel idLabel; private JTextField idJTextField;
    private JLabel nameLabel; private JTextField nameJTextField;
    private JLabel surnameLabel; private JTextField surnameJTextField;
    private JLabel usernameLabel; private JTextField usernameJTextField;
    private JLabel passwordLabel; private JTextField passwordJTextField;
    private JLabel balanceLabel; private JNumberField balanceJNumberField;
    private JLabel securityQuestionLabel; private JTextField securityQuestionJTextField;
    private JLabel securityAnswerLabel; private JTextField securityAnswerJTextField;

    private ArrayList<ArrayList<String>> allUsersForTable;

    public AdminPanel() {
        super();

        this.idLabel = new JLabel("Id: ");
        this.nameLabel = new JLabel("Name: ");
        this.surnameLabel = new JLabel("Surname: ");
        this.usernameLabel = new JLabel("Username: ");
        this.passwordLabel = new JLabel("Password: ");
        this.balanceLabel = new JLabel("Balance: ");
        this.securityQuestionLabel = new JLabel("Gizli soru (Şifre unutulunca kullanılacak): ");
        this.securityAnswerLabel = new JLabel("Gizli soru cevabı: ");

        this.idJTextField = new JTextField();
        idJTextField.setEditable(false);
        this.nameJTextField = new JTextField();
        this.surnameJTextField = new JTextField();
        this.usernameJTextField = new JTextField();
        this.passwordJTextField = new JTextField();
        this.balanceJNumberField = new JNumberField();
        balanceJNumberField.setEditable(false);
        this.securityQuestionJTextField = new JTextField();
        securityQuestionJTextField.setEditable(false);
        this.securityAnswerJTextField = new JTextField();
        securityAnswerJTextField.setEditable(true);

        JPanel formPanel = new JPanel(new GridLayout(0,2));
        formPanel.add(new BorderLayoutPanelNorth(idLabel)); formPanel.add(new BorderLayoutPanelNorth(idJTextField));
        formPanel.add(new BorderLayoutPanelNorth(nameLabel)); formPanel.add(new BorderLayoutPanelNorth(nameJTextField));
        formPanel.add(new BorderLayoutPanelNorth(surnameLabel)); formPanel.add(new BorderLayoutPanelNorth(surnameJTextField));
        formPanel.add(new BorderLayoutPanelNorth(usernameLabel)); formPanel.add(new BorderLayoutPanelNorth(usernameJTextField));
        formPanel.add(new BorderLayoutPanelNorth(passwordLabel)); formPanel.add(new BorderLayoutPanelNorth(passwordJTextField));
        formPanel.add(new BorderLayoutPanelNorth(balanceLabel)); formPanel.add(new BorderLayoutPanelNorth(balanceJNumberField));
        formPanel.add(new BorderLayoutPanelNorth(securityQuestionLabel)); formPanel.add(new BorderLayoutPanelNorth(securityQuestionJTextField));
        formPanel.add(new BorderLayoutPanelNorth(securityAnswerLabel)); formPanel.add(new BorderLayoutPanelNorth(securityAnswerJTextField));

        updateButton =  new JButton(Bundle.UPDATE_USER);
        deleteButton = new JButton(Bundle.DELETE_USER);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(updateButton, FlowLayout.LEFT);
        buttonPanel.add(deleteButton, FlowLayout.CENTER);

        userDaoImplementation = new UserDaoImplementation();

        allUsersForTable = userDaoImplementation.getAllForTable();

        userTable = new ListJTable(allUsersForTable, userDaoImplementation.getColumnsForTable());

        JScrollPane scrollPane = new JScrollPane(userTable);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());

        this.add(centerPanel, BorderLayout.WEST);
        this.add(formPanel, BorderLayout.EAST);
        this.add(buttonPanel, BorderLayout.SOUTH);

        userTable.getSelectionModel().addListSelectionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) {
            String id = userTable.getValueAt(userTable.getSelectedRow(),0).toString();
            String name = userTable.getValueAt(userTable.getSelectedRow(),2).toString();
            String surname = userTable.getValueAt(userTable.getSelectedRow(), 3).toString();
            String username = userTable.getValueAt(userTable.getSelectedRow(), 4).toString();
            String password = userTable.getValueAt(userTable.getSelectedRow(), 5).toString();
            String balance = userTable.getValueAt(userTable.getSelectedRow(), 6).toString();
            String secQuestion = userTable.getValueAt(userTable.getSelectedRow(), 8).toString();
            String secAnswer = userTable.getValueAt(userTable.getSelectedRow(), 9).toString();

            idJTextField.setText(id); nameJTextField.setText(name); surnameJTextField.setText(surname);
            usernameJTextField.setText(username); passwordJTextField.setText(password);
            balanceJNumberField.setText(balance); securityQuestionJTextField.setText(secQuestion);
            securityAnswerJTextField.setText(secAnswer);

            updateButton.setEnabled(true);
            deleteButton.setEnabled(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        User user = getUser();
        if(e.getActionCommand().equals(deleteButton.getActionCommand())) {
            // delete
            deleteUser(String.valueOf(user.getId()));
        } else if(e.getActionCommand().equals(updateButton.getActionCommand())) {
            // update
           userDaoImplementation.update(String.valueOf(user.getId()), user);
        }
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    private void deleteUser(String id) {
        userDaoImplementation.delete(id);
    }

    public User getUser() {
        return new User(
                Integer.valueOf(this.getId()),
                new Date().toString(),
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

    public String getId() {
        return idJTextField.getText().trim();
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
        return passwordJTextField.getText().trim();
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
}
