package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import plugin.Plugin;

public class CenterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected MainPanel mainPanel;
	protected JScrollPane scrollPane;
	protected JTextArea text;
	protected JPanel panelPlugins;

	public CenterPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
		this.text = new JTextArea(20,65);
		this.scrollPane = new JScrollPane(this.text);
		List<Plugin> plugins=new ArrayList<Plugin>();
		this.panelPlugins=new PluginsPanel(plugins);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(scrollPane);
		this.add(panelPlugins);
	}
	
	public CenterPanel(MainPanel mainPanel, String text) {
		this(mainPanel);
		this.text.setText(text);
	}
}
