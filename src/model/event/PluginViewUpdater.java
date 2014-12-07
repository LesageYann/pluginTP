package model.event;

import java.io.File;

import javax.swing.JFrame;

public class PluginViewUpdater implements PluginListener {
	private JFrame frame;

	public PluginViewUpdater(JFrame f) {
		this.frame = f;
	}

	@Override
	public void pluginAdded(File f) {
		this.frame.update(null);
	}

	@Override
	public void pluginRemoved(File f) {
		this.frame.update(null);
	}

}
