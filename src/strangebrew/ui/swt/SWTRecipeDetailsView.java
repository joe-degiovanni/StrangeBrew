package strangebrew.ui.swt;


import strangebrew.ui.core.*;
import strangebrew.ui.core.widgets.*;

import strangebrew.ui.swt.widgets.*;


import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

/**
 * @author mike
 *
 *
 */
public class SWTRecipeDetailsView extends RecipeDetailsView {
	Composite myContainer;
	FormLayout myLayout;
	SWTTextOutput myBrewerLabel;
	SWTTextInput myBrewer;
	SWTTextOutput myEfficiencyLabel;
	SWTNumberInput myEfficiency;
	SWTTextOutput myAlcoholLabel;
	SWTTextOutput myAlcohol;
	SWTTextOutput myAlcoholPostfix;
	SWTTextOutput myDateLabel;
	SWTTextInput myDate;
	SWTTextOutput myMashLabel;
	SWTCheckBox myMash;
	SWTTextOutput myAttenuationLabel;
	SWTNumberInput myAttenuation;
	SWTTextOutput myIBULabel;
	SWTTextOutput myIBU;
	SWTTextOutput myIBUPostfix;
	SWTTextOutput myStyleLabel;
	SWTDropdown myStyle;
	SWTTextOutput myOGLabel;
	SWTNumberInput myOG;
	SWTTextOutput myColourLabel;
	SWTTextOutput myColour;
	SWTTextOutput myColourPostfix;
	SWTTextOutput myYeastLabel;
	SWTDropdown myYeast;
	SWTTextOutput myFGLabel;
	SWTNumberInput myFG;


	public SWTRecipeDetailsView(Composite container) {
		myContainer = container;
	}
	
	public void init() {
		myBrewerLabel = new SWTTextOutput();
		myBrewerLabel.init(myContainer);
		myBrewer = new SWTTextInput(myController);
		myBrewer.init(myContainer);
		myEfficiencyLabel = new SWTTextOutput();
		myEfficiencyLabel.init(myContainer);
		myEfficiency = new SWTNumberInput(myController);
		myEfficiency.init(myContainer);
		myAlcoholLabel = new SWTTextOutput();
		myAlcoholLabel.init(myContainer);
		myAlcohol = new SWTTextOutput();
		myAlcohol.init(myContainer);
		myAlcoholPostfix = new SWTTextOutput();
		myAlcoholPostfix.init(myContainer);
		myDateLabel = new SWTTextOutput();
		myDateLabel.init(myContainer);
		myDate = new SWTTextInput(myController);
		myDate.init(myContainer);
		myMashLabel = new SWTTextOutput();
		myMashLabel.init(myContainer);
		myMash = new SWTCheckBox(myController);
		myMash.init(myContainer);
		myAttenuationLabel = new SWTTextOutput();
		myAttenuationLabel.init(myContainer);
		myAttenuation = new SWTNumberInput(myController);
		myAttenuation.init(myContainer);
		myIBULabel = new SWTTextOutput();
		myIBULabel.init(myContainer);
		myIBU = new SWTTextOutput();
		myIBU.init(myContainer);
		myIBUPostfix = new SWTTextOutput();
		myIBUPostfix.init(myContainer);
		myStyleLabel = new SWTTextOutput();
		myStyleLabel.init(myContainer);
		myStyle = new SWTDropdown(myController);
		myStyle.init(myContainer);
		myOGLabel = new SWTTextOutput();
		myOGLabel.init(myContainer);
		myOG = new SWTNumberInput(myController);
		myOG.init(myContainer);
		myColourLabel = new SWTTextOutput();
		myColourLabel.init(myContainer);
		myColour = new SWTTextOutput();
		myColour.init(myContainer);
		myColourPostfix = new SWTTextOutput();
		myColourPostfix.init(myContainer);
		myYeastLabel = new SWTTextOutput();
		myYeastLabel.init(myContainer);
		myYeast = new SWTDropdown(myController);
		myYeast.init(myContainer);
		myFGLabel = new SWTTextOutput();
		myFGLabel.init(myContainer);
		myFG = new SWTNumberInput(myController);
		myFG.init(myContainer);
		
		myLayout = new FormLayout();
		myLayout.marginHeight = 3;
		myLayout.marginWidth = 3;
		myContainer.setLayout(myLayout);		
	}
	
	private void setSize(SWTFormWidget control, int height, int width) {
		FormData data = control.getFormData();
		if (width != 0) {
			data.width = width;
		}
		if (height != 0) {
			data.height = height;
		}
		control.getControl().setLayoutData(data);
	}
	
	private void align(SWTFormWidget control, int direction, 
			SWTFormWidget target, int alignment, int offset) {

		FormData data = control.getFormData();
		FormAttachment fa;

		if (target != null) {
			fa = new FormAttachment(target.getControl(), offset, alignment);
		} else {
			fa = new FormAttachment(0, offset);
		}
		
		switch (direction) {
		case SWT.LEFT:
			data.left = fa;
			break;
		case SWT.BOTTOM:
			data.bottom = fa;
			break;
		case SWT.RIGHT:
			data.right = fa;
			break;
		case SWT.TOP:
			data.top = fa;
			break;
		} 
		control.getControl().setLayoutData(data);
	}
	
	private void attach(SWTFormWidget control, SWTFormWidget target,
			int offset) {
		align(control, SWT.LEFT, target, SWT.RIGHT, offset);
		align(control, SWT.BOTTOM, target, SWT.BOTTOM, 0);
	}

	public void layout() {
		setSize(myBrewer, 0, 200);
		setSize(myAlcohol, 0, 50);
		setSize(myEfficiency, 0, 50);
		setSize(myDate, 0, 120);
		setSize(myAttenuation, 0, 50);
		setSize(myIBU, 0, 50);
		setSize(myStyle, 0, 200);
		setSize(myOG, 0, 50);
		setSize(myColour, 0, 50);
		setSize(myYeast, 0, 200);
		setSize(myFG, 0, 50);
		
		align(myBrewerLabel, SWT.LEFT, null, SWT.NONE, 5);
		align(myBrewerLabel, SWT.TOP, null, SWT.NONE, 5);
		attach(myBrewer, myBrewerLabel, 5);
		attach(myEfficiencyLabel, myBrewer, 20);
        attach(myEfficiency, myEfficiencyLabel, 5);		
		attach(myAlcoholLabel, myEfficiency, 10);
        attach(myAlcohol, myAlcoholLabel, 5);		
		attach(myAlcoholPostfix, myAlcohol, 5);
		align(myDateLabel, SWT.RIGHT, myDate, SWT.LEFT, -5);
		align(myDateLabel, SWT.BOTTOM, myDate, SWT.BOTTOM, 0);
		align(myDate, SWT.TOP, myBrewer, SWT.BOTTOM, 5);
		align(myDate, SWT.LEFT, myBrewer, SWT.LEFT, 0);
		align(myMash, SWT.TOP, myBrewer, SWT.BOTTOM, 5);
		align(myMash, SWT.RIGHT, myBrewer, SWT.RIGHT, 10);
		align(myMashLabel, SWT.RIGHT, myMash, SWT.LEFT, -10);
		align(myMashLabel, SWT.BOTTOM, myMash, SWT.BOTTOM, 0);
		align(myAttenuationLabel, SWT.RIGHT, myEfficiencyLabel, SWT.RIGHT, 0);
		align(myAttenuationLabel, SWT.BOTTOM, myMash, SWT.BOTTOM, 0);
		align(myAttenuation, SWT.BOTTOM, myAttenuationLabel, SWT.BOTTOM, 0);
		align(myAttenuation, SWT.LEFT, myEfficiency, SWT.LEFT, 0);
		align(myIBULabel, SWT.BOTTOM, myAttenuation, SWT.BOTTOM, 0);
		align(myIBULabel, SWT.RIGHT, myAlcoholLabel, SWT.RIGHT, 0);
		align(myIBU, SWT.BOTTOM, myIBULabel, SWT.BOTTOM, 0);
		align(myIBU, SWT.LEFT, myAlcohol, SWT.LEFT, 0);
		align(myIBUPostfix, SWT.LEFT, myAlcoholPostfix, SWT.LEFT, 0);
		align(myIBUPostfix, SWT.BOTTOM, myIBU, SWT.BOTTOM, 0);
		align(myStyleLabel, SWT.RIGHT, myStyle, SWT.LEFT, -5);
		align(myStyleLabel, SWT.BOTTOM, myStyle, SWT.BOTTOM, 0);
		align(myStyle, SWT.TOP, myDate, SWT.BOTTOM, 5);
		align(myStyle, SWT.LEFT, myDate, SWT.LEFT, 0);
		align(myOGLabel, SWT.RIGHT, myAttenuationLabel, SWT.RIGHT, 0);
		align(myOGLabel, SWT.BOTTOM, myStyle, SWT.BOTTOM, 0);
		align(myOG, SWT.BOTTOM, myOGLabel, SWT.BOTTOM, 0);
		align(myOG, SWT.LEFT, myAttenuation, SWT.LEFT, 0);
		align(myColourLabel, SWT.BOTTOM, myOG, SWT.BOTTOM, 0);
		align(myColourLabel, SWT.RIGHT, myIBULabel, SWT.RIGHT, 0);
		align(myColour, SWT.BOTTOM, myColourLabel, SWT.BOTTOM, 0);
		align(myColour, SWT.LEFT, myIBU, SWT.LEFT, 0);
		align(myColourPostfix, SWT.LEFT, myIBUPostfix, SWT.LEFT, 0);
		align(myColourPostfix, SWT.BOTTOM, myColour, SWT.BOTTOM, 0);
		align(myYeastLabel, SWT.RIGHT, myYeast, SWT.LEFT, -5);
		align(myYeastLabel, SWT.BOTTOM, myYeast, SWT.BOTTOM, 0);
		align(myYeast, SWT.TOP, myStyle, SWT.BOTTOM, 5);
		align(myYeast, SWT.LEFT, myStyle, SWT.LEFT, 0);
		align(myFGLabel, SWT.RIGHT, myOGLabel, SWT.RIGHT, 0);
		align(myFGLabel, SWT.BOTTOM, myYeast, SWT.BOTTOM, 0);
		align(myFG, SWT.BOTTOM, myFGLabel, SWT.BOTTOM, 0);
		align(myFG, SWT.LEFT, myOG, SWT.LEFT, 0);
		
		myContainer.layout();
		myContainer.pack();
	}
	
	public void display() {
		// Not needed in SWT
	}
	
	public void dispose() {
        // @TODO Figure out who should dispose myContainer
	}

	public TextOutput getBrewerLabel() {
		return myBrewerLabel;
	}
	
	public TextInput getBrewer() {
		return myBrewer;
	}
	
	public TextOutput getEfficiencyLabel() {
		return myEfficiencyLabel;
	}

	public NumberInput getEfficiency() {
		return myEfficiency;
	}
	
	public TextOutput getAlcoholLabel() {
		return myAlcoholLabel;
	}

	public TextOutput getAlcohol() {
		return myAlcohol;
	}

	public TextOutput getAlcoholPostfix() {
		return myAlcoholPostfix;
	}
	
	public TextOutput getDateLabel() {
		return myDateLabel;
	}
	
	public TextInput getDate() {
		return myDate;
	}
	
	public CheckBox getMash() {
		return myMash;
	}
	
	public TextOutput getMashLabel() {
		return myMashLabel;
	}
	
	public TextOutput getAttenuationLabel() {
		return myAttenuationLabel;
	}
	
	public NumberInput getAttenuation() {
		return myAttenuation;
	}

	public TextOutput getIBULabel() {
		return myIBULabel;
	}

	public TextOutput getIBU() {
		return myIBU;
	}

	public TextOutput getIBUPostfix() {
		return myIBUPostfix;
	}

	public TextOutput getStyleLabel() {
		return myStyleLabel;
	}
	
	public Dropdown getStyle() {
		return myStyle;
	}
	
	public TextOutput getOGLabel() {
		return myOGLabel;
	}

	public NumberInput getOG() {
		return myOG;
	}

	public TextOutput getColourLabel() {
		return myColourLabel;
	}

	public TextOutput getColour() {
		return myColour;
	}

	public TextOutput getColourPostfix() {
		return myColourPostfix;
	}

	public TextOutput getYeastLabel() {
		return myYeastLabel;
	}
	
	public Dropdown getYeast() {
		return myYeast;
	}

	public TextOutput getFGLabel() {
		return myFGLabel;
	}

	public NumberInput getFG() {
		return myFG;
	}


}
