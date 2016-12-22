package ca.strangebrew.ui.swing;

import ca.strangebrew.Debug;
import ca.strangebrew.Options;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.util.Vector;

/*
 * This table will save its column widths, and restore them when you restart.
 */
public class SBTable extends JTable {
	
	private String name = "";

	public SBTable(String n) {
		name = n;
	}
	
	public SBTable() {
		// TODO Auto-generated constructor stub
	}

	public SBTable(TableModel arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public SBTable(TableModel arg0, TableColumnModel arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public SBTable(int arg0, int arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public SBTable(Vector arg0, Vector arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public SBTable(Object[][] arg0, Object[] arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public SBTable(TableModel arg0, TableColumnModel arg1, ListSelectionModel arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}
	
	
	public void setColumnWidths(Options p){
		if (name == "") return;
		setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		int colCount = getColumnCount();
		for (int i=0; i<colCount; i++){
			String key = ""+name+i;
			int k = p.getIProperty(key);
			if (k != 0)
				getColumnModel().getColumn(i).setPreferredWidth(k);
		}
		setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
	}
	
	public void saveColumnWidths(Options p){
		if (name == "") return;
		int colCount = getColumnCount();
		for (int j=0; j<colCount; j++){
			int k = getColumnModel().getColumn(j).getWidth();
			p.setIProperty(""+ name + j, k );
		}
		
	}

	@Override
	public Class<?> getColumnClass(int c) {
		Debug.print("Column Class " + c + " is " + getValueAt(0, c).getClass());
		return getValueAt(0, c).getClass();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
