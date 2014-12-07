package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

import model.plugin.Plugin;
import model.plugin.PluginFinder;

public class PluginFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected PluginFinder model;
	protected JMenu menu;
	protected MainPanel mainPanel;
	private Plugin currentPlugin;

	public PluginFrame(PluginFinder pf, String titre) {
		super(titre);
		this.model = pf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 600));
		JPanel a = new MainPanel(this);
		setContentPane(a);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public PluginFinder getModel() {
		return this.model;
	}

	@Override
	public void update(Graphics arg0) {
		this.mainPanel.update(arg0);
		super.update(arg0);
	}

	public void applyCurrentPlugin() {
		this.mainPanel.setText(this.currentPlugin.transform(this.mainPanel
				.getText()));
	}

	public void setCurrentPlugin(File item) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		String path = "plugins." + item.getName().replaceAll("\\.class$", "");
		System.out.println(path);
		Class<?> theClass = Class.forName(path);
		this.currentPlugin = (Plugin) theClass.newInstance();
	}
}
