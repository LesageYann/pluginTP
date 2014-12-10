package model.plugin;

import java.util.ArrayList;
import java.util.List;

public class PluginModel {
	protected List<Plugin> plugins;
	protected Plugin currentPlugin;
	protected PluginFinder finder;

	public PluginModel(PluginFinder finder) {
		this.finder = finder;
		this.plugins = new ArrayList<Plugin>();
	}

	public void setCurrentPlugin(String item) {
		for (Plugin p : plugins) {
			if (p.getLabel().equals(item)) {
				this.currentPlugin = p;
				return;
			}
		}
	}

	public void pluginAdded(Plugin p) {
		this.plugins.add(p);
	}

	public void pluginRemoved(Plugin p) {
		this.plugins.remove(p);
	}

	public List<String> listPluginLabels() {
		List<String> labels = new ArrayList<String>();
		for (Plugin p : plugins)
			labels.add(p.getLabel());
		return labels;
	}

	public String transform(String text) {
		return this.currentPlugin.transform(text);
	}

}
