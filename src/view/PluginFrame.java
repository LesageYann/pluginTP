package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;

import model.plugin.Plugin;
import model.plugin.PluginModel;

public class PluginFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected PluginModel model;
	protected JMenu menu;
	protected MainPanel mainPanel;

	public PluginFrame(PluginModel pf, String titre) {
		super(titre);
		this.model = pf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 600));
		mainPanel = new MainPanel(this);
		setContentPane(mainPanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public PluginModel getModel() {
		return this.model;
	}

	public void pluginAdded(Plugin p) {
		mainPanel.pluginAdded(p);
		this.repaint();
	}
	
	public void pluginRemoved(Plugin p) {
		mainPanel.pluginRemoved(p);
		this.repaint();
	}
	
	public void applyCurrentPlugin() {
		this.mainPanel.setText(model.transform(this.mainPanel
				.getText()));
	}

}
