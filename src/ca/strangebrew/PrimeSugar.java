package ca.strangebrew;

public class PrimeSugar extends Ingredient {

	// base data
	private double yield; 
	
	public PrimeSugar(){
		yield = 1.0;
	}

	public double getYield() {
		return yield;
	}

	public void setYield(double attenuation) {
		this.yield = attenuation;
	}

	public String toXML() {
		return "";
	}
}
