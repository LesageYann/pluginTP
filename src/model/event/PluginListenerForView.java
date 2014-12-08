package model.event;

import java.io.File;

import javax.swing.DefaultListModel;

public class PluginListenerForView implements PluginListener {
	DefaultListModel liste;
	
	public PluginListenerForView(DefaultListModel liste) {
		this.liste = liste;
	}

	@Override
	public void pluginAdded(File f) {
		this.liste.addElement(f);
	}

	@Override
	public void pluginRemoved(File f) {
		this.liste.removeElement(f);
	}
		
}
