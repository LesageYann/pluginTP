package model.event;

import model.plugin.Plugin;

public class PluginLogger implements PluginListener {

	@Override
	public void pluginAdded(Plugin p) {
		System.out.println(" plugin added : "+p.getLabel());
	}

	@Override
	public void pluginRemoved(Plugin p) {
		System.out.println(" plugin removed : "+ p.getLabel());
	}

}
