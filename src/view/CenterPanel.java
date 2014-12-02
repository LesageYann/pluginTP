package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CenterPanel extends JPanel {

	protected MainPanel mainPanel;
	protected JScrollPane scrollPane;
	protected JTextArea text;

	public CenterPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
		this.text = new JTextArea(20,65);
		this.scrollPane = new JScrollPane(this.text);
		this.add(scrollPane);
	}
	
	public CenterPanel(MainPanel mainPanel, String text) {
		this(mainPanel);
		this.text.setText(text);
	}
}
