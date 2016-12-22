package ca.strangebrew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeURLPopup extends JDialog implements ActionListener {
    private JButton closeButton; 
    private JTextArea taskOutput;
    
    public RecipeURLPopup(long id, String brewer, String name) {
        super();

        BoxLayout thisLayout = new BoxLayout(this.getContentPane(), javax.swing.BoxLayout.Y_AXIS);
        /*thisLayout.columnWeights = new double[]{0.1};
        thisLayout.columnWidths = new int[]{7};
        thisLayout.rowWeights = new double[]{0.7, 0.1, 0.1};
        thisLayout.rowHeights = new int[]{7, 7, 7};*/
        this.getContentPane().setLayout(thisLayout);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        String baseURL = Options.getInstance().getProperty("cloudURL");
        if (!baseURL.startsWith("http://")) {
            baseURL = "http://" + baseURL;
        }
        //Create the demo's UI.
        closeButton = new JButton("Close");
        closeButton.setActionCommand("close");
        closeButton.addActionListener(this);
        closeButton.setEnabled(true);
 
        taskOutput = new JTextArea(5, 100);
        taskOutput.setMargin(new Insets(5,5,5,5));
        taskOutput.setEditable(false);
        taskOutput.append(name + " by " + brewer + "\n");
        taskOutput.append("Recipe URL is: \n");
        taskOutput.append(baseURL + "/recipes/" + id);
        
        JPanel panel = new JPanel();
        
        add(panel, BorderLayout.PAGE_START);
        add(new JScrollPane(taskOutput), BorderLayout.CENTER);
        panel.add(closeButton);
        this.pack();
        this.setVisible(true);
        this.setSize(400, 300);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - getWidth()/2,
                (Toolkit.getDefaultToolkit().getScreenSize().height)/2 - getHeight()/2);
        this.setModal(true);
        this.setFocusable(true);
        
        //setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("close")) {
            this.dispose();
        }
    }
   
}

