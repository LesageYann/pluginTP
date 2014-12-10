package model.event;

import model.plugin.Plugin;

public class PluginListenerTest implements PluginListener{
	private boolean added;
	private boolean removed;
	
	public PluginListenerTest(){
		this.added = false;
		this.removed = false;
	}
	
	public void pluginAdded(Plugin f) {
		this.added=true;
	}
	
	public void pluginRemoved(Plugin f) {
		this.removed=true;
	}
	
	public boolean haveRemove(){
		return this.removed;
	}
	
	public boolean haveAdded(){
		return this.added;
	}
}
