package ca.strangebrew.ui.swing.dialogs;

import ca.strangebrew.SBStringUtils;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PotentialExtractCalcDialog extends javax.swing.JDialog implements ChangeListener {
	private JPanel jPanel1;
	private JLabel ppppgTxt;
	private JLabel platoLbl;
	private JLabel jLabel5;
	private JLabel jLabel3;
	private JSpinner moistureTxt;
	private JLabel jLabel2;
	private JSpinner extractTxt;
	private JLabel jLabel1;
	private JButton okbutton;
	private JPanel jPanel2;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		PotentialExtractCalcDialog inst = new PotentialExtractCalcDialog(frame);
		inst.setVisible(true);
	}
	
	public PotentialExtractCalcDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			
			this.setTitle("Potential Extract Calculator");

		jPanel1 = new JPanel();
		GridBagLayout jPanel1Layout = new GridBagLayout();
		jPanel1Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
		jPanel1Layout.rowHeights = new int[] {7, 7, 7, 7};
		jPanel1Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
		jPanel1Layout.columnWidths = new int[] {7, 7, 7, 7};
		jPanel1.setLayout(jPanel1Layout);
		getContentPane().add(jPanel1, BorderLayout.CENTER);
		jPanel1.setPreferredSize(new java.awt.Dimension(250, 135));

		jLabel1 = new JLabel();
		jPanel1.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		jLabel1.setText("Extract (DBCG):");

		extractTxt = new JSpinner();
		SpinnerNumberModel extractModel = new SpinnerNumberModel(80.0, 0.0,
				100.0, 1.0);
		extractTxt.setModel(extractModel);
		jPanel1.add(extractTxt, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		extractTxt.setPreferredSize(new java.awt.Dimension(43, extractTxt.getFont().getSize()*2));

		jLabel2 = new JLabel();
		jPanel1.add(jLabel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		jLabel2.setText("Moisture (%):");

		moistureTxt = new JSpinner();
		SpinnerNumberModel moistureModel = new SpinnerNumberModel(4.0, 0.0,
				100.0, 1.0);
		moistureTxt.setModel(moistureModel);
		jPanel1.add(moistureTxt, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		moistureTxt.setPreferredSize(new java.awt.Dimension(43, moistureTxt.getFont().getSize()*2));
		
		
		jLabel3 = new JLabel();
		jPanel1.add(jLabel3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		jLabel3.setText("PPPPG:");

		ppppgTxt = new JLabel();
		jPanel1.add(ppppgTxt, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		ppppgTxt.setText("ppppgLbl");

		jLabel5 = new JLabel();
		jPanel1.add(jLabel5, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		jLabel5.setText("Plato:");

		platoLbl = new JLabel();
		jPanel1.add(platoLbl, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		platoLbl.setText("jLabel6");

		jPanel2 = new JPanel();
		getContentPane().add(jPanel2, BorderLayout.SOUTH);

		okbutton = new JButton();
		jPanel2.add(okbutton);
		okbutton.setText("OK");
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setVisible(false);
				dispose();
			}
		});
		
		moistureTxt.addChangeListener(this);
		extractTxt.addChangeListener(this);
		

			this.setSize(258, 194);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * From http://www.brewingtechniques.com/bmg/noonan.html
	 *  degr. P = (DBCG - MC - 0.002) X Brewhouse Efficiency X 11.486
	 *  S.G. = (DBCG - MC - 0.002) X Brewhouse EfficiencyX 46.214 
	 */
	
	public void stateChanged(ChangeEvent evt) {
		// Object o = evt.getSource();
		
		double dbgc =  Double.parseDouble(extractTxt.getValue().toString()) / 100;
		double mc = Double.parseDouble(moistureTxt.getValue().toString()) / 100;
		double plato = (dbgc - mc - 0.002) * 11.486;
		double ppppg =  1 + (((dbgc - mc - 0.002) * 46.214) / 1000);
		ppppgTxt.setText(SBStringUtils.format(ppppg, 3));
		platoLbl.setText(SBStringUtils.format(plato, 2));
	}

}
