/*
 * Created on May 3, 2005
 *
 */
package ca.strangebrew.ui.swing;

import ca.strangebrew.Debug;
import ca.strangebrew.Fermentable;
import ca.strangebrew.Hop;
import ca.strangebrew.Style;
import ca.strangebrew.Yeast;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class ComboModel<T> extends AbstractListModel implements MutableComboBoxModel {
	
	List<T> list = new ArrayList<T>();
	T selected = null;
	
	public ComboModel() {
	 super();
     
     }
     
	public void addOrInsert(T o) {

		int i = 0;
		boolean found = false;
		boolean empty = false;
		while (i < list.size() && !found && !empty) {			
			if (o instanceof Yeast) {
				Yeast y = (Yeast) list.get(i);
				Yeast y2 = (Yeast) o;
				found = y.getName().equalsIgnoreCase(y2.getName());
				// empty = y.getName().equals("");
			} else if (o instanceof Fermentable) {
				Fermentable f = (Fermentable) list.get(i);
				Fermentable f2 = (Fermentable) o;
				found = f.getName().equalsIgnoreCase(f2.getName());
				// empty = f.getName().equals("");
			} else if (o instanceof Hop) {
				Hop h = (Hop) list.get(i);
				Hop h2 = (Hop) o;
				found = h.getName().equalsIgnoreCase(h2.getName());
				// empty = h.getName().equals("");
			} else if (o instanceof Style) {
				Style s = (Style) list.get(i);
				Style s2 = (Style) o;
				found = s.getName().equalsIgnoreCase(s2.getName());
				// empty = s.getName().equals("");				
				
			} else if (o instanceof String) {
				String q = (String) list.get(i);
				String q2 = (String) o;
				found = q.equalsIgnoreCase(q2);
				empty = q.equals("");
			}
			 
			i++;
		}
		
		// if it's not found, add it to the list & select it, 
		// otherwise, set the found index to the selected index
		
		if (!found) {
			Debug.print("removing dupe " + o.toString());
			list.add(o);			
			selected = o;
		} else {
			selected = list.get(i-1);
		}

	}
	
	public T getSelectedItem() {
		return selected;
	}
	
	public void setSelectedItem(Object item) {
		if ((selected != null && !selected.equals(item))
				|| (selected == null && item != null)) {
			// YUCK from useing generics + old SWING stuff
			selected = (T)item;
			fireContentsChanged(this, -1, -1);
		}
	}
	

	public int getSize() {
		return list.size();
	}

	public Object getElementAt(int index) {
		return list.get(index);
	}

	public void setList(List<T> l) {
		Debug.print("Size of list ("+l.size() + ") incoming: " + list.size());
		list = l;
		Debug.print("Size of list outgoing: " + list.size());
	}
	
	public void setList(T[] sList) {
		Debug.print("Size of list ("+sList.length + ") incoming: " + list.size());
		list.clear();
		for (int i=0; i<sList.length; i++) {
			list.add(sList[i]);
		}
		Debug.print("Size of list outgoing: " + list.size());
	}

	public void addElement(Object item) {
		// TODO Auto-generated method stub
		
	}

	public void removeElement(Object obj) {
		// TODO Auto-generated method stub
		
	}

	public void insertElementAt(Object item, int index) {
		// TODO Auto-generated method stub
		
	}

	public void removeElementAt(int index) {
		// TODO Auto-generated method stub
		
	}
}