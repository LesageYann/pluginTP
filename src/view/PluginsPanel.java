package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PluginsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JButton apply;
	protected JComboBox plugins;
	protected PluginFrame frame;

	public PluginsPanel(PluginFrame frame) {
		super();
		this.frame = frame;
		this.plugins = new JComboBox();
		this.plugins.addItemListener(new ItemChangeListener(frame,frame.getModel()));
		this.update(null);
		this.apply = new JButton("Apply");
		this.apply.addActionListener(new ApplyPluginListener(this.frame));
		this.add(plugins);
		this.add(apply);
	}

	public void pluginAdded(String label) {
		this.plugins.addItem(label);
		this.repaint();
	}
	
	public void pluginRemoved(String label) {
		this.plugins.removeItem(label);
		this.repaint();
	}
}
