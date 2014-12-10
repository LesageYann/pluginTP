package model.event;

import model.plugin.Plugin;

public interface PluginListener {

	public void pluginAdded(Plugin p);

	public void pluginRemoved(Plugin p);
}
