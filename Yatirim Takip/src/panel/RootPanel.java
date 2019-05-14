package panel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class RootPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private StockMarketPanel stockMarketPanel;
	private TimeDepositPanel timeDepositPanel;

	public RootPanel() {
		super();

		stockMarketPanel = new StockMarketPanel();

		timeDepositPanel = new TimeDepositPanel();

		JTabbedPane tabbedPane = new JTabbedPane();
		
		tabbedPane.add("Stock Market", stockMarketPanel);
		tabbedPane.add("Time Deposit", timeDepositPanel);
		
		this.setLayout(new BorderLayout());
		
		this.add(tabbedPane, BorderLayout.CENTER);
	}

	public StockMarketPanel getStockMarketPanel() {
		return stockMarketPanel;
	}
}
