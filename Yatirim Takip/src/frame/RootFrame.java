package frame;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import panel.RootPanel;

public class RootFrame extends JFrame implements ActionListener {

	private RootPanel rootPanel;

	public RootFrame() throws HeadlessException {
		super();
		
		this.setTitle("Finance");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		
		rootPanel = new RootPanel();
		this.add(rootPanel);

		rootPanel.getStockMarketPanel().getAddNewButton().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(rootPanel.getStockMarketPanel().getAddNewButton().getActionCommand().equals(e.getActionCommand())) {
			dispose();
		}
	}
}
