package frame;

import panel.ForgotPasswordPanel;
import statics.Bundle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordJFrame extends JFrame implements ActionListener {

    ForgotPasswordPanel forgotPasswordPanel;

    public ForgotPasswordJFrame() {
        super();
        this.setTitle("Forgot Password");
        this.setVisible(true);
        this.setSize(400, 150);
        this.setLocationRelativeTo(null);

        forgotPasswordPanel = new ForgotPasswordPanel();
        this.add(forgotPasswordPanel);

        this.forgotPasswordPanel.getShowMePasswordButton().addActionListener(this);

        this.invalidate();
        this.validate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(Bundle.SHOW_ME_PASSWORD)) {
            String password = forgotPasswordPanel.getPassword();
            if ( password != null ) {
                JOptionPane.showMessageDialog(new JFrame(), "Your password is: " + password, "Password", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Password cannot found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
