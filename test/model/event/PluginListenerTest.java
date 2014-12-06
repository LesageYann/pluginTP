package model.event;

import java.io.File;

public class PluginListenerTest implements PluginListener{
	private boolean added;
	private boolean removed;
	
	public PluginListenerTest(){
		this.added = false;
		this.removed = false;
	}
	
	public void pluginAdded(File f) {
		this.added=true;
	}
	
	public void pluginRemoved(File f) {
		this.removed=true;
	}
	
	public boolean haveRemove(){
		return this.removed;
	}
	
	public boolean haveAdded(){
		return this.added;
	}
}
