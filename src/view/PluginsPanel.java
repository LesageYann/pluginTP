package view;

import java.awt.Graphics;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PluginsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JButton apply;
	protected JComboBox<File> plugins;
	protected PluginFrame frame;

	public PluginsPanel(PluginFrame frame) {
		super();
		this.frame = frame;
		this.plugins = new JComboBox<File>();
		this.update(null);
		this.apply = new JButton("Apply");
		this.apply.addActionListener(new ApplyPluginListener(this.frame));
		this.add(plugins);
		this.add(apply);
	}

	@Override
	public void update(Graphics arg0) {
		this.plugins.removeAllItems();
		for (File p : this.frame.getModel().listPluginClassFiles())
				this.plugins.addItem(p);
		try {
			this.frame.setCurrentPlugin((File) plugins.getSelectedItem());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			JOptionPane.showMessageDialog(frame,
					"Error while selecting Plugin", "FATAL ERROR",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
