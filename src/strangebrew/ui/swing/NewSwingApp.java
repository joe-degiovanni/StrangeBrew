package strangebrew.ui.swing;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.*;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.*;

import strangebrew.*;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.ComboBoxModel;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder,
 * which is free for non-commercial use. If Jigloo is being used commercially
 * (ie, by a corporation, company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo. Please visit
 * www.cloudgarden.com for details. Use of Jigloo implies acceptance of these
 * licensing terms. ************************************* A COMMERCIAL LICENSE
 * HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be
 * used legally for any corporate or commercial purpose.
 * *************************************
 */

public class NewSwingApp extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JMenuItem helpMenuItem;
	private JMenu jMenu5;
	private JMenuItem deleteMenuItem;
	private JSeparator jSeparator1;
	private JMenuItem pasteMenuItem;
	private JLabel lblDate;
	private JTextField txtBrewer;
	private JLabel lblBrewer;
	private JTextField txtName;
	private JLabel lblName;
	private JPanel pnlDetails;
	private JTabbedPane jTabbedPane1;
	private JPanel jPanel1;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenu4;
	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	private JLabel lblAlc;
	private JMenuItem exportHTMLmenu;
	private JMenu exportMenu;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane1;
	private JTable tblHopsTotals;
	private JTable tblMaltTotals;
	private JPanel pnlHops;
	private JPanel pnlMalt;
	private JLabel lblSizeUnits;
	private JComboBox cmbSizeUnits;
	private JScrollPane scrMalts;
	private JPanel pnlMain;
	private JTable tblHops;
	private JScrollPane scpComments;
	private JTable tblMalt;
	private JLabel lblAlcValue;
	private JLabel lblColourValue;
	private JLabel lblIBUvalue;
	private JSpinner spnFG;
	private JSpinner spnOG;
	private JSpinner spnAtten;
	private JSpinner spnEffic;
	private JTextArea txtComments;
	private JLabel lblComments;
	private JFormattedTextField txtPostBoil;
	private JFormattedTextField txtPreBoil;
	private JComboBox cmbYeast;
	private JComboBox cmbStyle;
	private JTextField txtDate;
	private JLabel lblColour;
	private JLabel lblIBU;
	private JPanel pnlTables;
	private JLabel lblFG;
	private JLabel lblOG;
	private JLabel lblAtten;
	private JLabel lblEffic;
	private JLabel lblMash;
	private JLabel lblPostBoil;
	private JLabel lblPreBoil;
	private JLabel lblYeast;
	private JLabel lblStyle;
	private JMenuItem closeFileMenuItem;
	private JMenuItem saveAsMenuItem;
	private JMenuItem saveMenuItem;
	private JMenuItem openFileMenuItem;
	private JMenuItem newFileMenuItem;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;

	private MaltTableModel tblMaltModel;
	private DefaultTableModel tblMaltTotalsModel;
	private HopsTableModel tblHopsModel;
	private DefaultTableModel tblHopsTotalsModel;
	private ComboModel cmbYeastModel;
	private ComboModel cmbStyleModel;

	private Recipe myRecipe;
	DecimalFormat df1 = new DecimalFormat("####.0");
	DecimalFormat df2 = new DecimalFormat("#.00");
	DecimalFormat df3 = new DecimalFormat("0.000");

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		NewSwingApp inst = new NewSwingApp();
		inst.setVisible(true);
	}

	public NewSwingApp() {
		super();
		initGUI();
		// There has *got* to be a better way to do this:
		Database db = new Database();
		db.readDB("src/strangebrew/data");

		cmbStyleModel.setList(db.styleDB);
		cmbYeastModel.setList(db.yeastDB);

	}

	private void displayRecipe() {
		if (myRecipe == null)
			return;
		txtName.setText(myRecipe.getName());
		txtBrewer.setText(myRecipe.getBrewer());
		cmbStyleModel.addOrInsert(myRecipe.getStyleObj());
		cmbYeastModel.addOrInsert(myRecipe.getYeastObj());
		txtPreBoil.setValue(new Double(myRecipe.getPreBoilVol(myRecipe
				.getVolUnits())));
		txtPostBoil.setValue(new Double(myRecipe.getPostBoilVol(myRecipe
				.getVolUnits())));
		spnEffic.setValue(new Double(myRecipe.getEfficiency()));
		spnAtten.setValue(new Double(myRecipe.getAttenuation()));
		spnOG.setValue(new Double(myRecipe.getEstOg()));
		spnFG.setValue(new Double(myRecipe.getEstFg()));
		txtComments.setText(myRecipe.getComments());

		lblIBUvalue.setText(df1.format(myRecipe.getIbu()));
		lblColourValue.setText(df1.format(myRecipe.getSrm()));
		lblAlcValue.setText(df1.format(myRecipe.getAlcohol()));
		tblMaltModel.setData(myRecipe.getFermentablesList());
		tblHopsModel.setData(myRecipe.getHopsList());
		tblMaltTotalsModel.setDataVector(new String[][]{{"Totals:",
				"" + df1.format(myRecipe.getTotalMaltLbs()),
				myRecipe.getMaltUnits(), "" + df3.format(myRecipe.getEstOg()),
				"" + df1.format(myRecipe.getSrm()),
				"$" + df2.format(myRecipe.getTotalMaltCost()), "100"}},
				new String[]{"", "", "", "", "", "", ""});

		tblHopsTotalsModel.setDataVector(new String[][]{{"Totals:", "", "",
				"" + df1.format(myRecipe.getTotalHopsOz()),
				myRecipe.getHopUnits(), "", "",
				"" + df1.format(myRecipe.getIbu()),
				"$" + df2.format(myRecipe.getTotalHopsCost())}}, new String[]{
				"", "", "", "", "", "", "", "", ""});

	}

	private void initGUI() {
		try {

			this.setSize(520, 532);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					System.exit(1);
				}
			});
			{
				pnlMain = new JPanel();
				GridBagLayout jPanel2Layout = new GridBagLayout();
				jPanel2Layout.columnWeights = new double[]{0.1};
				jPanel2Layout.columnWidths = new int[]{7};
				jPanel2Layout.rowWeights = new double[]{0.1, 0.1, 0.1};
				jPanel2Layout.rowHeights = new int[]{7, 7, 7};
				pnlMain.setLayout(jPanel2Layout);
				this.getContentPane().add(pnlMain, BorderLayout.CENTER);
				{
					jPanel1 = new JPanel();
					pnlMain.add(jPanel1, new GridBagConstraints(0, 0, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									0), 0, 0));
					FlowLayout jPanel1Layout = new FlowLayout();
					jPanel1Layout.setAlignment(FlowLayout.LEFT);
					jPanel1.setLayout(jPanel1Layout);
					{
						lblName = new JLabel();
						jPanel1.add(lblName);
						lblName.setText("Name:");
					}
					{
						txtName = new JTextField();
						jPanel1.add(txtName);
						txtName.setText("Name");
						txtName
								.setPreferredSize(new java.awt.Dimension(179,
										20));
						txtName.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								myRecipe.setName(txtName.getText());
							}
						});
					}
				}
				{
					jTabbedPane1 = new JTabbedPane();
					pnlMain.add(jTabbedPane1, new GridBagConstraints(0, 1, 1,
							1, 0.1, 0.1, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));
					{
						pnlDetails = new JPanel();
						GridBagLayout pnlDetailsLayout = new GridBagLayout();
						pnlDetailsLayout.columnWeights = new double[]{0.1, 0.1,
								0.1, 0.1, 0.1, 0.1, 0.1};
						pnlDetailsLayout.columnWidths = new int[]{7, 7, 7, 7,
								7, 7, 7};
						pnlDetailsLayout.rowWeights = new double[]{0.1, 0.1,
								0.1, 0.1, 0.1, 0.1, 0.1};
						pnlDetailsLayout.rowHeights = new int[]{7, 7, 7, 7, 7,
								7, 7};
						pnlDetails.setLayout(pnlDetailsLayout);
						jTabbedPane1.addTab("Details", null, pnlDetails, null);
						{
							lblBrewer = new JLabel();
							pnlDetails.add(lblBrewer, new GridBagConstraints(0,
									0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblBrewer.setText("Brewer:");
						}
						{
							txtBrewer = new JTextField();
							pnlDetails.add(txtBrewer, new GridBagConstraints(1,
									0, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER,
									GridBagConstraints.HORIZONTAL, new Insets(
											0, 0, 0, 0), 0, 0));
							txtBrewer.setText("Brewer");
							txtBrewer.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									myRecipe.setBrewer(txtBrewer.getText());
								}
							});
						}
						{
							lblDate = new JLabel();
							pnlDetails.add(lblDate, new GridBagConstraints(0,
									1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblDate.setText("Date:");
						}
						{
							lblStyle = new JLabel();
							pnlDetails.add(lblStyle, new GridBagConstraints(0,
									2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblStyle.setText("Style:");
						}
						{
							lblYeast = new JLabel();
							pnlDetails.add(lblYeast, new GridBagConstraints(0,
									3, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblYeast.setText("Yeast:");
						}
						{
							lblPreBoil = new JLabel();
							pnlDetails.add(lblPreBoil, new GridBagConstraints(
									0, 4, 1, 1, 0.0, 0.0,
									GridBagConstraints.EAST,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblPreBoil.setText("Pre boil:");
						}
						{
							lblPostBoil = new JLabel();
							pnlDetails.add(lblPostBoil, new GridBagConstraints(
									0, 5, 1, 1, 0.0, 0.0,
									GridBagConstraints.EAST,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblPostBoil.setText("Post boil:");
						}
						{
							lblMash = new JLabel();
							pnlDetails.add(lblMash, new GridBagConstraints(0,
									6, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblMash.setText("Mash:");
						}
						{
							lblEffic = new JLabel();
							pnlDetails.add(lblEffic, new GridBagConstraints(3,
									0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblEffic.setText("Effic:");
						}
						{
							lblAtten = new JLabel();
							pnlDetails.add(lblAtten, new GridBagConstraints(3,
									1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblAtten.setText("Atten:");
						}
						{
							lblOG = new JLabel();
							pnlDetails.add(lblOG, new GridBagConstraints(3, 2,
									1, 1, 0.0, 0.0, GridBagConstraints.EAST,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblOG.setText("OG:");
						}
						{
							lblFG = new JLabel();
							pnlDetails.add(lblFG, new GridBagConstraints(3, 3,
									1, 1, 0.0, 0.0, GridBagConstraints.EAST,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblFG.setText("FG:");
						}
						{
							lblIBU = new JLabel();
							pnlDetails.add(lblIBU, new GridBagConstraints(5, 0,
									1, 1, 0.0, 0.0, GridBagConstraints.EAST,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblIBU.setText("IBU:");
						}
						{
							lblAlc = new JLabel();
							pnlDetails.add(lblAlc, new GridBagConstraints(5, 2,
									1, 1, 0.0, 0.0, GridBagConstraints.EAST,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblAlc.setText("%Alc:");
						}
						{
							lblColour = new JLabel();
							pnlDetails.add(lblColour, new GridBagConstraints(5,
									1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblColour.setText("Colour:");
						}
						{
							txtDate = new JTextField();
							pnlDetails.add(txtDate, new GridBagConstraints(1,
									1, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER,
									GridBagConstraints.HORIZONTAL, new Insets(
											0, 0, 0, 0), 0, 0));
							txtDate.setText("Date");
						}
						{
							cmbStyleModel = new ComboModel();
							cmbStyle = new JComboBox();
							pnlDetails.add(cmbStyle, new GridBagConstraints(1,
									2, 2, 1, 0.0, 0.0,
									GridBagConstraints.CENTER,
									GridBagConstraints.HORIZONTAL, new Insets(
											0, 0, 0, 0), 0, 0));
							cmbStyle.setModel(cmbStyleModel);
							cmbStyle.setMaximumSize(new java.awt.Dimension(100,
									32767));
							cmbStyle.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									Style s = (Style) cmbStyleModel
											.getSelectedItem();
									if (s != myRecipe.getStyleObj()) {
										myRecipe.setStyle(s);
									}
								}
							});
						}
						{
							txtPreBoil = new JFormattedTextField();
							pnlDetails.add(txtPreBoil, new GridBagConstraints(
									1, 4, 1, 1, 0.0, 0.0,
									GridBagConstraints.WEST,
									GridBagConstraints.HORIZONTAL, new Insets(
											0, 0, 0, 0), 0, 0));
							txtPreBoil.setText("Pre Boil");
							txtPreBoil.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out
											.println("txtPreBoil.actionPerformed, event="
													+ evt);
									//TODO add your code for
									// txtPreBoil.actionPerformed
								}
							});
						}
						{
							txtPostBoil = new JFormattedTextField();
							pnlDetails.add(txtPostBoil, new GridBagConstraints(
									1, 5, 1, 1, 0.0, 0.0,
									GridBagConstraints.WEST,
									GridBagConstraints.HORIZONTAL, new Insets(
											0, 0, 0, 0), 0, 0));
							txtPostBoil.setText("Post Boil");
							txtPostBoil.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out
											.println("txtPostBoil.actionPerformed, event="
													+ evt);
									//TODO add your code for
									// txtPostBoil.actionPerformed
								}
							});
						}
						{
							lblComments = new JLabel();
							pnlDetails.add(lblComments, new GridBagConstraints(
									3, 4, 1, 1, 0.0, 0.0,
									GridBagConstraints.EAST,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblComments.setText("Comments:");
						}

						{
							SpinnerNumberModel spnEfficModel = new SpinnerNumberModel(
									75.0, 0.0, 100.0, 1.0);
							spnEffic = new JSpinner();
							pnlDetails.add(spnEffic, new GridBagConstraints(4,
									0, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER,
									GridBagConstraints.HORIZONTAL, new Insets(
											0, 0, 0, 0), 0, 0));
							spnEffic.setModel(spnEfficModel);
							spnEffic.addChangeListener(new ChangeListener() {
								public void stateChanged(ChangeEvent evt) {
									myRecipe.setEfficiency(Double
											.parseDouble(spnEffic.getValue()
													.toString()));
									displayRecipe();
								}
							});
							spnEffic.setEditor(new JSpinner.NumberEditor(
									spnEffic, "00.#"));
						}
						{
							SpinnerNumberModel spnAttenModel = new SpinnerNumberModel(
									75.0, 0.0, 100.0, 1.0);
							spnAtten = new JSpinner();
							pnlDetails.add(spnAtten, new GridBagConstraints(4,
									1, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER,
									GridBagConstraints.HORIZONTAL, new Insets(
											0, 0, 0, 0), 0, 0));
							spnAtten.setModel(spnAttenModel);
							spnAtten.addChangeListener(new ChangeListener() {
								public void stateChanged(ChangeEvent evt) {
									myRecipe.setAttenuation(Double
											.parseDouble(spnAtten.getValue()
													.toString()));
									displayRecipe();
								}
							});
							spnAtten.setEditor(new JSpinner.NumberEditor(
									spnAtten, "00.#"));
						}
						{
							SpinnerNumberModel spnOgModel = new SpinnerNumberModel(
									1.000, 0.900, 2.000, 0.001);
							spnOG = new JSpinner();
							pnlDetails.add(spnOG, new GridBagConstraints(4, 2,
									1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
									GridBagConstraints.HORIZONTAL, new Insets(
											0, 0, 0, 0), 0, 0));
							spnOG.setModel(spnOgModel);
							spnOG.addChangeListener(new ChangeListener() {
								public void stateChanged(ChangeEvent evt) {
									myRecipe.setEstOg(Double.parseDouble(spnOG
											.getValue().toString()));
									displayRecipe();
								}
							});
							spnOG.setEditor(new JSpinner.NumberEditor(spnOG,
									"0.000"));
						}
						{
							SpinnerNumberModel spnFgModel = new SpinnerNumberModel(
									1.000, 0.900, 2.000, 0.001);
							spnFG = new JSpinner();
							pnlDetails.add(spnFG, new GridBagConstraints(4, 3,
									1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
									GridBagConstraints.HORIZONTAL, new Insets(
											0, 0, 0, 0), 0, 0));
							spnFG.setModel(spnFgModel);
							spnFG.setEditor(new JSpinner.NumberEditor(spnFG,
									"0.000"));
							spnFG.addChangeListener(new ChangeListener() {
								public void stateChanged(ChangeEvent evt) {
									// set the new FG, and update alc:
									myRecipe.setEstFg(Double.parseDouble(spnFG
											.getValue().toString()));
									displayRecipe();
								}
							});
						}
						{
							lblIBUvalue = new JLabel();
							pnlDetails.add(lblIBUvalue, new GridBagConstraints(
									6, 0, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblIBUvalue.setText("IBUs");
						}
						{
							lblColourValue = new JLabel();
							pnlDetails.add(lblColourValue,
									new GridBagConstraints(6, 1, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							lblColourValue.setText("Colour");
						}
						{
							lblAlcValue = new JLabel();
							pnlDetails.add(lblAlcValue, new GridBagConstraints(
									6, 2, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER,
									GridBagConstraints.NONE, new Insets(0, 0,
											0, 0), 0, 0));
							lblAlcValue.setText("Alc");
						}
						{
							scpComments = new JScrollPane();
							pnlDetails.add(scpComments, new GridBagConstraints(
									3, 5, 4, 2, 0.0, 0.0,
									GridBagConstraints.CENTER,
									GridBagConstraints.BOTH, new Insets(0, 0,
											0, 0), 0, 0));
							{
								txtComments = new JTextArea();
								scpComments.setViewportView(txtComments);
								txtComments.setText("Comments");
								txtComments.setWrapStyleWord(true);
							}
						}
						{
							cmbYeastModel = new ComboModel();
							cmbYeast = new JComboBox();
							pnlDetails.add(cmbYeast, new GridBagConstraints(1,
									3, 2, 1, 0.0, 0.0,
									GridBagConstraints.CENTER,
									GridBagConstraints.HORIZONTAL, new Insets(
											0, 0, 0, 0), 0, 0));
							cmbYeast.setModel(cmbYeastModel);
							cmbYeast.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									Yeast y = (Yeast) cmbYeastModel
											.getSelectedItem();
									if (y != myRecipe.getYeastObj()) {
										myRecipe.setYeast(y);
									}
								}
							});
						}
						{
							ComboBoxModel cmbSizeUnitsModel = new DefaultComboBoxModel(
									new String[]{"Item One", "Item Two"});
							cmbSizeUnits = new JComboBox();
							pnlDetails.add(cmbSizeUnits,
									new GridBagConstraints(2, 4, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							cmbSizeUnits.setModel(cmbSizeUnitsModel);
						}
						{
							lblSizeUnits = new JLabel();
							pnlDetails.add(lblSizeUnits,
									new GridBagConstraints(2, 5, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							lblSizeUnits.setText("Size Units");
						}
					}
				}
				{
					pnlTables = new JPanel();
					BoxLayout pnlMaltsLayout = new BoxLayout(pnlTables,
							javax.swing.BoxLayout.Y_AXIS);
					pnlMain.add(pnlTables, new GridBagConstraints(0, 2, 1, 1,
							0.5, 0.5, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));

					pnlTables.setLayout(pnlMaltsLayout);
					{
						pnlMalt = new JPanel();
						pnlTables.add(pnlMalt);
						BorderLayout pnlMaltLayout1 = new BorderLayout();
						FlowLayout pnlMaltLayout = new FlowLayout();
						pnlMalt.setBorder(BorderFactory.createTitledBorder(
								new LineBorder(new java.awt.Color(0, 0, 0), 1,
										false), "Fermentables",
								TitledBorder.LEADING, TitledBorder.TOP,
								new java.awt.Font("Dialog", 1, 12),
								new java.awt.Color(51, 51, 51)));
						pnlMalt.setLayout(pnlMaltLayout1);
						{
							jScrollPane1 = new JScrollPane();
							pnlMalt.add(jScrollPane1, BorderLayout.CENTER);
							{
								tblMaltModel = new MaltTableModel();
								tblMalt = new JTable();
								jScrollPane1.setViewportView(tblMalt);
								BorderLayout tblMaltLayout = new BorderLayout();
								tblMalt.setLayout(tblMaltLayout);
								tblMalt.setModel(tblMaltModel);
								TableColumn column = null;
								//								for (int i = 0; i < tblMalt.getColumnCount();
								// i++) {
								//									column = tblMalt.getColumnModel()
								//										.getColumn(i);
								//									if (i == 0) {
								//										column.setPreferredWidth(100); //sport column
								// is bigger
								//									} else {
								//										column.setPreferredWidth(50);
								//									}
								//								}
							}
						}
						{
							tblMaltTotalsModel = new DefaultTableModel(
									new String[][]{{""}}, new String[]{"Malt",
											"Amount", "Units", "Points", "Lov",
											"Cost/U", "%"});
							tblMaltTotals = new JTable();
							pnlMalt.add(tblMaltTotals, BorderLayout.SOUTH);
							tblMaltTotals.setModel(tblMaltTotalsModel);
							tblMaltTotals.getTableHeader().setEnabled(false);

						}
					}
					{
						pnlHops = new JPanel();
						BorderLayout pnlHopsLayout = new BorderLayout();
						pnlHops
								.setBorder(BorderFactory.createTitledBorder(
										new LineBorder(new java.awt.Color(0, 0,
												0), 1, false), "Hops",
										TitledBorder.LEADING, TitledBorder.TOP,
										new java.awt.Font("Dialog", 1, 12),
										new java.awt.Color(51, 51, 51)));
						pnlHops.setLayout(pnlHopsLayout);
						pnlTables.add(pnlHops);
						{
							tblHopsTotalsModel = new DefaultTableModel(
									new String[][]{{""}}, new String[]{
											"Column 1", "Column 2"});
							tblHopsTotals = new JTable();
							pnlHops.add(tblHopsTotals, BorderLayout.SOUTH);
							tblHopsTotals.setModel(tblHopsTotalsModel);

						}
						{
							jScrollPane2 = new JScrollPane();
							pnlHops.add(jScrollPane2, BorderLayout.CENTER);
							{
								tblHopsModel = new HopsTableModel();
								tblHops = new JTable();
								jScrollPane2.setViewportView(tblHops);
								BorderLayout tblHopsLayout = new BorderLayout();
								tblHops.setLayout(tblHopsLayout);
								tblHops.setModel(tblHopsModel);

							}
						}
					}

				}
			}
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("File");
					{
						newFileMenuItem = new JMenuItem();
						jMenu3.add(newFileMenuItem);
						newFileMenuItem.setText("New");
					}
					{
						openFileMenuItem = new JMenuItem();
						jMenu3.add(openFileMenuItem);
						openFileMenuItem.setText("Open");
						openFileMenuItem
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										String path = getClass()
												.getProtectionDomain()
												.getCodeSource().getLocation()
												.toString().substring(6)
												+ "\\";
										JFileChooser fc = new JFileChooser(path);

										// Show open dialog; this method does
										// not return until the dialog is closed
										int returnVal = fc
												.showOpenDialog(jMenuBar1);
										if (returnVal == JFileChooser.APPROVE_OPTION) {
											File file = fc.getSelectedFile();

											System.out.print("Opening: "
													+ file.getName() + ".\n");
											ImportXml imp = new ImportXml(file
													.toString());
											myRecipe = imp.handler.getRecipe();
											myRecipe.calcMaltTotals();
											myRecipe.calcHopsTotals();
											myRecipe.mash
													.setMaltWeight(myRecipe
															.getTotalMashLbs());
											myRecipe.mash.calcMashSchedule();
											displayRecipe();
										} else {
											System.out
													.print("Open command cancelled by user.\n");
										}

									}
								});
					}
					{
						saveMenuItem = new JMenuItem();
						jMenu3.add(saveMenuItem);
						saveMenuItem.setText("Save");
					}
					{
						saveAsMenuItem = new JMenuItem();
						jMenu3.add(saveAsMenuItem);
						saveAsMenuItem.setText("Save As ...");
						saveAsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								// This is just a test right now to see that
								// stuff is changed.
								System.out.print(myRecipe.toXML());

							}
						});
					}
					{
						exportMenu = new JMenu();
						jMenu3.add(exportMenu);
						exportMenu.setText("Export");
						{
							exportHTMLmenu = new JMenuItem();
							exportMenu.add(exportHTMLmenu);
							exportHTMLmenu.setText("HTML");
							exportHTMLmenu
									.addActionListener(new ActionListener() {
										public void actionPerformed (
												ActionEvent evt) {
											
											try{
											saveAsHTML();
											} catch (Exception e){
												
											}

										}
									});
						}
					}
					{
						closeFileMenuItem = new JMenuItem();
						jMenu3.add(closeFileMenuItem);
						closeFileMenuItem.setText("Close");
					}
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Exit");
						exitMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								// exit program
								System.exit(0);
							}
						});
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("Edit");
					{
						cutMenuItem = new JMenuItem();
						jMenu4.add(cutMenuItem);
						cutMenuItem.setText("Cut");
					}
					{
						copyMenuItem = new JMenuItem();
						jMenu4.add(copyMenuItem);
						copyMenuItem.setText("Copy");
					}
					{
						pasteMenuItem = new JMenuItem();
						jMenu4.add(pasteMenuItem);
						pasteMenuItem.setText("Paste");
					}
					{
						jSeparator1 = new JSeparator();
						jMenu4.add(jSeparator1);
					}
					{
						deleteMenuItem = new JMenuItem();
						jMenu4.add(deleteMenuItem);
						deleteMenuItem.setText("Delete");
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Help");
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("Help");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Auto-generated method for setting the popup menu for a component
	 */
	private void setComponentPopupMenu(final java.awt.Component parent,
			final javax.swing.JPopupMenu menu) {
		parent.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent e) {
				if (e.isPopupTrigger())
					menu.show(parent, e.getX(), e.getY());
			}
			public void mouseReleased(java.awt.event.MouseEvent e) {
				if (e.isPopupTrigger())
					menu.show(parent, e.getX(), e.getY());
			}
		});
	}

	class MaltTableModel extends AbstractTableModel {
		private String[] columnNames = {"Malt", "Amount", "Units", "Points",
				"Lov", "Cost/U", "%"};

		private ArrayList data = null;

		public MaltTableModel() {
			data = new ArrayList();
		}

		public void addRow(Fermentable m) {
			data.add(m);
		}

		public void setData(ArrayList d) {
			data = d;
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			Fermentable m = (Fermentable) data.get(row);
			try {
				switch (col) {
					case 0 :
						return m.getName();
					case 1 :
						return new Double(df1.format(m
								.getAmountAs(m.getUnits())));
					case 2 :
						return m.getUnits();
					case 3 :
						return new Double(m.getPppg());
					case 4 :
						return new Double(m.getLov());
					case 5 :
						return new Double(m.getCostPerU());
					case 6 :
						return df1.format(new Double(m.getPercent()));

				}
			} catch (Exception e) {
			};
			return "";
		}

		/*
		 * JTable uses this method to determine the default renderer/ editor for
		 * each cell. If we didn't implement this method, then the last column
		 * would contain text ("true"/"false"), rather than a check box.
		 */
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		/*
		 * Don't need to implement this method unless your table's editable.
		 */
		public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			if (col < 2) {
				return false;
			} else {
				return true;
			}
		}

		/*
		 * Don't need to implement this method unless your table's data can
		 * change.
		 */
		public void setValueAt(Object value, int row, int col) {

			Fermentable m = (Fermentable) data.get(row);
			try {
				switch (col) {
					case 0 :
						m.setName(value.toString());
					case 1 :
						m.setAmount(Double.parseDouble(value.toString()));
					case 2 :
						m.setUnits(value.toString());
					case 3 :
						m.setPppg(Double.parseDouble(value.toString()));
					case 4 :
						m.setLov(Double.parseDouble(value.toString()));
					case 5 :
						m.setCost(Double.parseDouble(value.toString()));
					case 6 :
						m.setPercent(Double.parseDouble(value.toString()));

				}
			} catch (Exception e) {
			};

			fireTableCellUpdated(row, col);
		}
	}
	class HopsTableModel extends AbstractTableModel {
		private String[] columnNames = {"Hop", "Type", "Alpha", "Amount",
				"Units", "Add", "Min", "IBU", "Cost/u"};

		private ArrayList data = null;

		public HopsTableModel() {
			data = new ArrayList();
		}

		public void addRow(Hop h) {
			data.add(h);
		}

		public void setData(ArrayList d) {
			data = d;
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			Hop h = (Hop) data.get(row);
			try {
				switch (col) {
					case 0 :
						return h.getName();
					case 1 :
						return h.getType();
					case 2 :
						return new Double(h.getAlpha());
					case 3 :
						return new Double(h.getAmountAs(h.getUnits()));
					case 4 :
						return new Double(h.getUnits());
					case 5 :
						return new Double(h.getAdd());
					case 6 :
						return new Double(h.getMinutes());
					case 7 :
						return new Double(df1.format(h.getIBU()));
					case 8 :
						return new Double(h.getCostPerU());

				}
			} catch (Exception e) {
			};
			return "";
		}

		public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			if (col < 2) {
				return false;
			} else {
				return true;
			}
		}

		/*
		 * Don't need to implement this method unless your table's data can
		 * change.
		 */
		/*
		 * public void setValueAt(Object value, int row, int col) {
		 * 
		 * Hop h = (Hop)data.get(row); try { switch (col){ case 0 :
		 * h.setName(value.toString()); case 1 : return h.getType(); case 2 :
		 * return new Double(h.getAlpha()); case 3 : return new
		 * Double(h.getAmountAs(h.getUnits())); case 4 : return new
		 * Double(h.getUnits()); case 5 : return new Double(h.getAdd()); case 6 :
		 * return new Double(h.getMinutes()); case 7 : return new
		 * Double(h.getIBU()); case 8 : return new Double(h.getCostPerU()); } }
		 * catch (Exception e){};
		 * 
		 * fireTableCellUpdated(row, col); }
		 */
	}

	class ComboModel extends AbstractListModel implements ComboBoxModel {

		List list = new ArrayList();
		String last = "X";
		Object selected;

		public void addOrInsert(Object o) {

			int i = 0;
			boolean found = false;
			while (i < list.size() && !found) {
				if (o.getClass().getName().toString().equals(
						"strangebrew.Yeast")) {
					Yeast y = (Yeast) list.get(i);
					Yeast y2 = (Yeast) o;
					found = y.getName().equalsIgnoreCase(y2.getName());
				} else {
					Style s = (Style) list.get(i);
					Style s2 = (Style) o;
					found = s.getName().equalsIgnoreCase(s2.getName());
				}
				i++;
			}
			if (!found) {
				list.add(o);
			}
			setSelectedItem(o);

		}

		public Object getSelectedItem() {
			return selected;
		}

		public void setSelectedItem(Object item) {
			if ((selected != null && !selected.equals(item))
					|| (selected == null && item != null)) {
				selected = item;
				fireContentsChanged(this, -1, -1);
			}
		}

		public int getSize() {
			return list.size();
		}

		public Object getElementAt(int index) {
			return list.get(index);
		}

		void changeModel() {
			list.add(last);
			last = last + "X";
			fireContentsChanged(this, 0, list.size());
		}

		public void setList(ArrayList l) {
			list = l;
		}
	}
	
	public void saveAsHTML() throws Exception{
			// save file as xml, then transform it to html
			File tmp = new File("tmp.xml");
			FileWriter out = new FileWriter(tmp);
			out.write(myRecipe.toXML());
			out.close();
			String htmlFileName = myRecipe.getName() + ".html";
			File htmlFile = new File(htmlFileName);
			FileOutputStream output = new java.io.FileOutputStream(htmlFile);
			XmlTransformer.writeStream("tmp.xml",
					"src/strangebrew/data/recipeToHtml.xslt", output);

	}

}