/**
 * $Id: Hop.java,v 1.17 2012/06/02 19:40:58 dougedey Exp $
 * Created on Oct 5, 2004
 *
 * Base class for hops.  This object doesn't do much except hold data and
 * get/set data.
 */

package ca.strangebrew

public class Hop extends Ingredient implements Comparable<Ingredient> {
	double alpha
	String add
	int minutes
	double storage
	double IBU

	// Hops should know about hop types
	static final public String LEAF = "Leaf"
	static final public String PELLET = "Pellet"
	static final public String PLUG = "Plug"
	static final public String BOIL = "Boil"
	static final public String FWH = "FWH"
	static final public String DRY = "Dry"
	static final public String MASH = "Mash"

	static final public String[] forms = [LEAF, PELLET, PLUG]
	static final public String[] addTypes = [BOIL, FWH, DRY, MASH]

	// Constructors:

	public Hop() {
		// default constructor
		name ="New Hop"
		type = LEAF
		add = BOIL
		setUnits(Quantity.OZ) // oz
	}

	public Hop(String u, String t) {
		units = u
		type = t
		add = BOIL
	}

	public String toXML() {
		StringBuffer sb = new StringBuffer()
		sb.append("    <ITEM>\n")
		sb.append("      <HOP>" + getName() + "</HOP>\n")
		sb.append("      <AMOUNT>" + getAmountAs(getUnits()) + "</AMOUNT>\n")
		sb.append("      <TIME>" + getMinutes() + "</TIME>\n")
		sb.append("      <UNITS>" + getUnitsAbrv() + "</UNITS>\n")
		sb.append("      <FORM>" + getType() + "</FORM>\n")
		sb.append("      <ALPHA>" + alpha + "</ALPHA>\n")
		sb.append("      <COSTOZ>" + getCostPerU() + "</COSTOZ>\n")
		sb.append("      <ADD>" + add + "</ADD>\n")
		sb.append("      <DESCRIPTION>"
				+ SBStringUtils.subEntities(getDescription())
				+ "</DESCRIPTION>\n")
		sb.append("      <DATE>" + getDate() + "</DATE>\n")
		sb.append("    </ITEM>\n")
		return sb.toString()
	}

	public int compareTo(Ingredient i) {
		if (i instanceof Hop) {
			return compareTo((Hop) i)
		} else {
			return super.compareTo(i)
		}
	}
	
	public int compareTo(Hop h) {
		// Check to see if the additions are at the same time
		if (this.getMinutes() == 0 && h.getMinutes() == 0) {
			// Check to see if we have dry hopping
			if (this.getAdd() == h.getAdd()) {
				// Same addition, continue the compare
				return super.compareTo(h)
			} else {
				// Different addition type, so compare that. Boil is luckily
				// prior to Dry
				return this.getAdd().compareToIgnoreCase(h.getAdd())

			}
		} else {
			// Times are not the same, straightforward comparrison
			int result = ((Integer) h.getMinutes()).compareTo((Integer) this
					.getMinutes())
			return (result == 0 ? -1 : result)
		}
	}
	
	

}
