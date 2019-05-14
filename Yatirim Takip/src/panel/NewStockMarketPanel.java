package panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.JNumberField;
import pojo.StockMarket;
import statics.Bundle;
import statics.Global;

public class NewStockMarketPanel extends JPanel {
	
	private JLabel companyLabel; private JTextField companyJTextField;
	private JLabel numberOfStockJLabel; private JNumberField numberOfStockJNumberField;
	private JLabel unitPriceLabel; private JNumberField unitPriceJNumberField;
	
	private JButton addNewButton;
	private JButton cancelButton;

	 public NewStockMarketPanel() {
		super();
		
		companyLabel = new JLabel("Company"); companyJTextField = new JTextField();
		numberOfStockJLabel = new JLabel("Number Of Stock: "); numberOfStockJNumberField = new JNumberField();
		unitPriceLabel = new JLabel("Unit Price: "); unitPriceJNumberField = new JNumberField();
		
		addNewButton = new JButton(Bundle.ADD_NEW);
        cancelButton = new JButton(Bundle.CANCEL_BUTTON);
        
        this.setLayout(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(0,2));
        
        formPanel.add(new BorderLayoutPanelNorth(companyLabel));formPanel.add(new BorderLayoutPanelNorth(companyJTextField));
        formPanel.add(new BorderLayoutPanelNorth(numberOfStockJLabel));formPanel.add(new BorderLayoutPanelNorth(numberOfStockJNumberField));
        formPanel.add(new BorderLayoutPanelNorth(unitPriceLabel));formPanel.add(new BorderLayoutPanelNorth(unitPriceJNumberField));
	
	 
        this.add(formPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addNewButton, FlowLayout.LEFT);
        buttonPanel.add(cancelButton, FlowLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        
	 }

	public String getCompany() {
		return companyJTextField.getText().trim();
	}

	public int getNumberOfStock() {
		return Integer.parseInt(numberOfStockJNumberField.getText().trim());
	}

	public double getUnitPrice() {
		return Double.parseDouble(unitPriceJNumberField.getText().trim());
	}

	public JButton getAddNewButton() {
		return addNewButton;
	}
	
	public JButton getCancelButton() {
		return cancelButton;
	}

	public boolean validateForm() {
		return !(this.getCompany() == "");
	}
	
	public StockMarket getStockMarket() {
		return new StockMarket(
				getCompany(), 
				getNumberOfStock(), 
				getUnitPrice(), 
				getNumberOfStock() * getUnitPrice(), Global.user.getUsername());
	}
	 
	 
}






























