package ca.strangebrew

/**
 * $Id $
 * @author aavis
 *
 */
public class Misc extends Ingredient {

	String comments
	String stage
	int time
	static final public String MASH = "Mash"
	static final public String BOIL = "Boil"
	static final public String PRIMARY = "Primary"
	static final public String SECONDARY = "Secondary"
	static final public String BOTTLE = "Bottle"
	static final public String KEG = "Keg"
	static final public String[] stages = [MASH, BOIL, PRIMARY, SECONDARY, BOTTLE, KEG]
	
	// default constructor
	public  Misc() {
		setName("")
		setCost(0)
		setDescription("")
		setUnits(Quantity.G)
	}

	public String toXML(){
	    StringBuffer sb = new StringBuffer()
	    sb.append( "    <ITEM>\n" )
	    sb.append( "      <NAME>"+getName()+"</NAME>\n" )
	    sb.append( "      <AMOUNT>"+getAmountAs(getUnits())+"</AMOUNT>\n" )
	    sb.append( "      <UNITS>"+getUnits()+"</UNITS>\n" )
	    sb.append( "      <STAGE>"+stage+"</STAGE>\n" )
	    sb.append( "      <TIME>"+time+"</TIME>\n" )
	    sb.append( "      <COMMENTS>"+SBStringUtils.subEntities(comments)+"</COMMENTS>\n" )
	    sb.append( "    </ITEM>\n" )
	    return sb.toString()
	}
}
