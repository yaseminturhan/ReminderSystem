package frame;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import implementation.StockMarketImplementation;
import panel.NewStockMarketPanel;

public class NewStockMarketFrame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private NewStockMarketPanel newStockMarketPanel;

	public NewStockMarketFrame() throws HeadlessException {
		super();
		
		this.setTitle("Save New Stock Market");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		newStockMarketPanel = new NewStockMarketPanel();
		this.add(newStockMarketPanel);
		
		newStockMarketPanel.getAddNewButton().addActionListener(this);
		newStockMarketPanel.getCancelButton().addActionListener(this);
		
		this.invalidate();
		this.validate();
		this.repaint();
		this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(newStockMarketPanel.getAddNewButton().getActionCommand())) {
			new StockMarketImplementation().save(this.newStockMarketPanel.getStockMarket());
			dispose();
			RootFrame rootFrame = new RootFrame();
			rootFrame.setVisible(true);
		} else if(e.getActionCommand().equals(newStockMarketPanel.getCancelButton().getActionCommand())) {
			dispose();
		}
	}
}
