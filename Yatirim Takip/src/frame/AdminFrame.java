package frame;

import panel.AdminPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class AdminFrame extends JFrame implements ActionListener {

    private AdminPanel adminPanel;

    private JButton updateButton;
    private JButton deleteButton;

    public AdminFrame() {
        super();
        this.setTitle("Admin Panel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 200);
        this.setLocationRelativeTo(null);

        adminPanel = new AdminPanel();
        this.add(adminPanel);

        this.updateButton = adminPanel.getUpdateButton();
        this.deleteButton = adminPanel.getDeleteButton();

        this.updateButton.addActionListener(this);
        this.deleteButton.addActionListener(this);

        this.invalidate();
        this.validate();
        this.repaint();
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(updateButton.getActionCommand()) || e.getActionCommand().equals(deleteButton.getActionCommand())) {
            adminPanel.actionPerformed(e);
            this.setVisible(false);
            AdminFrame adminFrame = new AdminFrame();
            adminFrame.setVisible(true);
        }
    }
}
