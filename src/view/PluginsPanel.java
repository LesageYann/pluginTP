package view;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

public class PluginsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JList liste;
	protected JButton apply;
	
	public PluginsPanel(ListModel plugins){
		super();
		this.apply = new JButton("Apply");
		this.liste= new JList(plugins);
		this.liste.setVisibleRowCount(5);
		this.add(liste);
		this.add(apply);
	}
}
