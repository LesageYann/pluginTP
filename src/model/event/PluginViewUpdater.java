package model.event;

import model.plugin.Plugin;
import model.plugin.PluginModel;
import view.PluginFrame;

public class PluginViewUpdater implements PluginListener {
	private PluginFrame frame;
	private PluginModel model;

	public PluginViewUpdater(PluginFrame f, PluginModel m) {
		this.frame = f;
		this.model = m;
	}

	@Override
	public void pluginAdded(Plugin p) {
		this.model.pluginAdded(p);
		this.frame.pluginAdded(p);
	}

	@Override
	public void pluginRemoved(Plugin p) {
		this.model.pluginRemoved(p);
		this.frame.pluginRemoved(p);
	}
	
}
