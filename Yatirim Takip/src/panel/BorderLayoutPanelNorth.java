package panel;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

public class BorderLayoutPanelNorth extends JPanel{

	private Component component;
	
	public BorderLayoutPanelNorth(Component component) {
		super();
		this.setLayout(new BorderLayout());
		this.add(component, BorderLayout.NORTH);
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}
	

}
