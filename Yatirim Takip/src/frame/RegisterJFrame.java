package frame;

import implementation.UserDaoImplementation;
import panel.RegisterPanel;
import pojo.User;
import statics.Bundle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterJFrame extends JFrame implements ActionListener {

	RegisterPanel registerPanel;
	
	public RegisterJFrame() {
		super();
		this.setTitle("Register");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);

		registerPanel = new RegisterPanel();
		this.add(registerPanel);

		this.registerPanel.getRegisterButton().addActionListener(this);
		this.registerPanel.getCancelButton().addActionListener(this);
		
		this.invalidate();
		this.validate();
		this.repaint();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Bundle.REGISTER_BUTTON)) {
			if(registerPanel.validateForm()) {
				User user = registerPanel.getUser();
				new UserDaoImplementation().save(user);
				JOptionPane.showMessageDialog(new JFrame(), "User successfully registered. Welcome " + user.getName(), "Success", JOptionPane.INFORMATION_MESSAGE);
				LoginJFrame loginJFrame = new LoginJFrame();
				loginJFrame.setVisible(true);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "User values are not validated!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if(e.getActionCommand().equals(Bundle.CANCEL_BUTTON)) {

		}
	}
}
