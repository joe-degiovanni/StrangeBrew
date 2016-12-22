/**
 * Created on Oct 4, 2004
 * $Id: Fermentable.java,v 1.11 2012/06/02 19:40:58 dougedey Exp $
 *
 * @author aavis
 * <p>
 * This is the base malt class.  It doesn't do much, except hold data
 * and get/set data
 */

package ca.strangebrew

public class Fermentable extends Ingredient {

    // base data
    double pppg
    double lov
    boolean mashed
    boolean steeped
    boolean fermentable = true
    double percent
    boolean prime

    final static private double basePppg = 1.047

    public Fermentable(Fermentable f) {
        setName(f.getName())
        pppg = f.getPppg()
        lov = f.getLov()
        setAmount(f.getAmountAs(f.getUnits()))
        setUnits(f.getUnits())
        mashed = f.getMashed()
        prime = f.getPrime()
        percent = f.getPercent()
    }

    public Fermentable(String u) {
        setName("")
        pppg = 1.000
        setUnits(u)
    }

    public Fermentable() {
        // default constructor
        setName("")
        pppg = 0
        lov = 0
        setAmount(1.0)
        setUnits(Options.getInstance().getProperty("optMaltU"))
        mashed = true
        prime = false
    }



    static public double getBasePppg() {
        return basePppg
    }

    // Need to add the spaces and type attributes to make this
    // backwards-compatible with SB1.8:
    public String toXML() {
        StringBuffer sb = new StringBuffer()
        sb.append("    <ITEM>\n")
        sb.append("      <MALT>" + getName() + "</MALT>\n")
        sb.append("      <AMOUNT>" + getAmountAs(getUnits()) + "</AMOUNT>\n")
        sb.append("      <PERCENT>" + SBStringUtils.format(percent, 1) + "</PERCENT>\n")
        sb.append("      <UNITS>" + getUnitsAbrv() + "</UNITS>\n")
        sb.append("      <POINTS>" + pppg + "</POINTS>\n")
        sb.append("      <LOV>" + lov + "</LOV>\n")
        sb.append("      <MASHED>" + mashed + "</MASHED>\n")
        sb.append("      <STEEPED>" + steeped + "</STEEPED>\n")
        sb.append("      <FERMENTS>" + fermentable + "</FERMENTS>\n")
        sb.append("      <COSTLB>" + getCostPerU() + "</COSTLB>\n")
        sb.append("      <DESCRIPTION>" + SBStringUtils.subEntities(getDescription()) + "</DESCRIPTION>\n")
        sb.append("    </ITEM>\n")
        return sb.toString()
    }

}
