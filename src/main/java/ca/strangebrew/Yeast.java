package ca.strangebrew;

/**
 * $Id: Yeast.java,v 1.1 2006/04/07 13:59:14 andrew_avis Exp $
 * @author aavis
 * Created on Oct 21, 2004
 *
 */
public class Yeast extends Ingredient {
	// I'm not sure what else needs to be added to yeast,
	// but if we need to, we can add it here
	
	// should handle defaults here:
	public Yeast(){
		// setName("A yeast");
	}

	@Override
	public String toXML() {
		return "";
	}

}
