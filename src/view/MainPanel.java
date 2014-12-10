package view;

import javax.swing.JComponent;
import javax.swing.JPanel;

import model.plugin.Plugin;

public class MainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected CenterPanel center;
	protected PluginFrame frame;

	public MainPanel(PluginFrame f) {
		this.frame = f;
		this.center = new CenterPanel(this.frame, "test");
		add(center);
	}

	public JComponent getCentre() {
		return this.center;
	}

	public PluginFrame getFrame() {
		return this.frame;
	}

	public String getText() {
		return this.center.getText();
	}

	public void setText(String s) {
		this.center.setText(s);
	}

	public void pluginAdded(Plugin p) {
		this.center.pluginAdded(p);
	}
	
	public void pluginRemoved(Plugin p) {
		this.center.pluginRemoved(p);
	}
}
