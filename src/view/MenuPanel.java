package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPanel extends JMenuBar {
	protected MainPanel mainPanel;

	public MenuPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
		JMenu file = new JMenu("File");
		file.add(new JMenuItem("New"));
		file.add(new JMenuItem("Open ..."));
		file.addSeparator();
		file.add(new JMenuItem("Exit"));
		
		JMenu tools = new JMenu("Tools");
		tools.add(new JMenuItem("plugin 1"));
		tools.add(new JMenuItem("plugin 2"));
		
		JMenu help = new JMenu("Help");
		help.add(new JMenuItem("plugin 1"));
		help.add(new JMenuItem("plugin 2"));
		
		this.add(file);
		this.add(tools);
		this.add(help);
	}
	

}
