package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CenterPanel extends JPanel {

	protected MainPanel mainPanel;
	protected JTextArea text;

	public CenterPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
		this.text = new JTextArea(50,10);
	}
	
	public CenterPanel(MainPanel mainPanel, String text) {
		this(mainPanel);
		this.text.setText(text);
	}

}
