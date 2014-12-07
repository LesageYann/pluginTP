package model.event;

import java.io.File;

public interface PluginListener {

	public void pluginAdded(File f);

	public void pluginRemoved(File f);
}
