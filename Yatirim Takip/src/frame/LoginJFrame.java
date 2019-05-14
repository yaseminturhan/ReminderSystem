package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import implementation.UserDaoImplementation;
import panel.LoginPanel;
import statics.Bundle;

public class LoginJFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private LoginPanel loginPanel;
	
	public LoginJFrame() {
		super();
		this.setTitle("Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(450, 210);
		this.setLocationRelativeTo(null);
		
		loginPanel = new LoginPanel();
		
		loginPanel.getLoginButton().addActionListener(this);
		loginPanel.getRegisterButton().addActionListener(this);
		loginPanel.getPasswordForgotButton().addActionListener(this);
		
		this.add(loginPanel);
		
		this.invalidate();
		this.validate();
		this.repaint();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Bundle.LOGIN_BUTTON)) {
			if(loginPanel.getUserName().equals("admin") && loginPanel.getPassword().equals("admin")) {
				AdminFrame adminFrame = new AdminFrame();
				adminFrame.setVisible(true);
				dispose();
			} else if(new UserDaoImplementation().login(loginPanel.getUserName(), loginPanel.getPassword())) {
				RootFrame rootFrame = new RootFrame();
				dispose();
				rootFrame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Username or password is wrong!", "Login Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if(e.getActionCommand().equals(Bundle.REGISTER_BUTTON)) {
			RegisterJFrame registerJFrame = new RegisterJFrame();
			this.setVisible(false);
			registerJFrame.setVisible(true);
		} else if(e.getActionCommand().equals(Bundle.FORGOT_PASSWORD)) {
			ForgotPasswordJFrame forgotPasswordJFrame = new ForgotPasswordJFrame();
			forgotPasswordJFrame.setVisible(true);
		}
	}
	
}
