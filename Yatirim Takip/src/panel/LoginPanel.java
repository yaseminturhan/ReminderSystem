package panel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import statics.Bundle;

public class LoginPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	
	private JButton loginButton;
	private JButton registerButton;
	private JButton passwordForgotButton;
	
	public LoginPanel() {
		this.setLayout(new GridLayout(0, 2));
		this.usernameLabel = new JLabel("username: ");
		this.passwordLabel = new JLabel("Password: ");
		this.usernameTextField = new JTextField();
		this.passwordTextField = new JPasswordField();
		
		this.loginButton = new JButton(Bundle.LOGIN_BUTTON);
		this.registerButton = new JButton(Bundle.REGISTER_BUTTON);
		this.passwordForgotButton = new JButton(Bundle.FORGOT_PASSWORD);
		
		this.add(new BorderLayoutPanelNorth(usernameLabel)); this.add(new BorderLayoutPanelNorth(usernameTextField));
		this.add(new BorderLayoutPanelNorth(passwordLabel)); this.add(new BorderLayoutPanelNorth(passwordTextField));
		this.add(new BorderLayoutPanelNorth(loginButton));
		this.add(new BorderLayoutPanelNorth(registerButton));
		this.add(new BorderLayoutPanelNorth(passwordForgotButton));
		
	}
	
	public String getUserName() {
		return this.usernameTextField.getText().trim();
	}
	
	public String getPassword() {
		return String.valueOf(this.passwordTextField.getPassword()).trim();
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	public JButton getPasswordForgotButton() {
		return passwordForgotButton;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JButton getRegisterButton() {
		return registerButton;
	}

	public void setPasswordForgotButton(JButton passwordForgotButton) {
		this.passwordForgotButton = passwordForgotButton;
	}

}
