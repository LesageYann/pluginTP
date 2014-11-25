package model.event;

import java.io.File;

public class PluginLogger implements PluginListener {

	@Override
	public void pluginAdded(File f) {
		System.out.printf(" plugin added : %s \n", f.getName());
	}

	@Override
	public void pluginRemoved(File f) {
		System.out.printf(" plugin removed : %s \n", f.getName());
	}

}
