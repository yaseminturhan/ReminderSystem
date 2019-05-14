package components;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListJTable extends JTable {
	
	private String[][] data;
	private String[] column;
	
	private ArrayList<ArrayList<String>> dataA;
	private ArrayList<String> columnA;
	
	public ListJTable(ArrayList<ArrayList<String>> dataA, ArrayList<String> columnA) {
		super();
		this.dataA = dataA;
		this.columnA = columnA;

		this.column = columnA.toArray(new String[columnA.size()]);
		DefaultTableModel model = (DefaultTableModel) this.getModel();
		for(String col : column) {
			model.addColumn(col);
		}

		listToData();
		
	}
	
	private void listToData(){

		this.data = new String[this.dataA.size()][this.columnA.size()];
		for(int i=0;i<this.dataA.size();i++) {
			for(int j =0; j < this.dataA.get(i).size(); j++) {
				this.data[i][j] = this.dataA.get(i).get(j);
			}
		}
		this.updateData();

	}
	
	public void updateData() {
		DefaultTableModel model = (DefaultTableModel) this.getModel();
		model.setRowCount(0);
		for(String[] row : this.data) {
			model.addRow(row);
		}
		for(int i=0;i< this.data.length;i++) {
			for(int j=0;j< this.column.length; j++) {
				model.fireTableCellUpdated(i,j);
				repaint(this.getCellRect(i,j,false));
			}
		}
		model.fireTableDataChanged();
	}

	public ArrayList<ArrayList<String>> getDataA() {
		return dataA;
	}

	public void setDataA(ArrayList<ArrayList<String>> dataA) {
		this.dataA = dataA;
		listToData();
	}

	public ArrayList<String> getColumnA() {
		return columnA;
	}

	public void setColumnA(ArrayList<String> columnA) {
		this.columnA = columnA;
		listToData();
	}

	

}
