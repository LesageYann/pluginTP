package model.event;

import java.io.File;

public class PluginLogger implements PluginListener {

	@Override
	public void pluginAdded(File f) {
		System.out.println(" plugin added : "+f.getName());
	}

	@Override
	public void pluginRemoved(File f) {
		System.out.println(" plugin removed : "+ f.getName());
	}

}
