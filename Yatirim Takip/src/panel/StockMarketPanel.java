package panel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import components.ListJTable;
import frame.NewStockMarketFrame;
import implementation.StockMarketImplementation;
import statics.Bundle;

public class StockMarketPanel extends JPanel implements ActionListener{
	
	private JButton addNewButton;
	private StockMarketImplementation stockMarketImplementation;
	private ListJTable stockTable;

	private ArrayList<ArrayList<String>> allDataforTable;

	public StockMarketPanel() {
		super();
		this.setLayout(new BorderLayout());

		stockMarketImplementation = new StockMarketImplementation();
		
		addNewButton = new JButton(Bundle.ADD_NEW);

		allDataforTable = stockMarketImplementation.getAllForTable();

		stockTable = new ListJTable(allDataforTable, stockMarketImplementation.getColumnsForTable());
		
		JScrollPane scrollPane = new JScrollPane(stockTable);
		
		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel(new BorderLayout());
		JPanel newButtonStockPanel = new JPanel();
		
		newButtonStockPanel.add(addNewButton);

		JPanel infoPanel = new JPanel(new BorderLayout());
		double totalSpent = stockMarketImplementation.getTotalSpent();
		double currentVal = calculateCurrentValue(allDataforTable);

		JLabel totalLabel = new JLabel("You spent totally: " + totalSpent);
		JLabel currentLabel = new JLabel("Current value is: " + currentVal);
		JLabel profitLabel = new JLabel("Profit: " + (currentVal - totalSpent));
		infoPanel.add(totalLabel, BorderLayout.NORTH);
		infoPanel.add(currentLabel, BorderLayout.CENTER);
		infoPanel.add(profitLabel, BorderLayout.SOUTH);

		// Bottom Panel
		bottomPanel.add(new BorderLayoutPanelNorth(newButtonStockPanel), BorderLayout.EAST);
		bottomPanel.add(new BorderLayoutPanelNorth(infoPanel), BorderLayout.WEST);
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);

		addNewButton.addActionListener(this);

	}

	private double calculateCurrentValue(ArrayList<ArrayList<String>> datas) {
		double total = 0;
		for(ArrayList<String> dataas : datas) {
			total += Double.valueOf(dataas.get(dataas.size() - 1));
		}
		return total;
	}

	public JButton getAddNewButton() {
		return addNewButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Bundle.ADD_NEW)) {
			NewStockMarketFrame newStockMarketFrame = new NewStockMarketFrame();
			newStockMarketFrame.setVisible(true);
		}
	}
	
}
