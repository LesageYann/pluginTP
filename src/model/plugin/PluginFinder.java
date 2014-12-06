package model.plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Timer;

import model.event.PluginListener;


public class PluginFinder implements ActionListener {
	protected File dir;
	protected PluginFilter filter = new PluginFilter();
	protected Timer timer;
	protected List<PluginListener> listeners= new ArrayList<PluginListener>();
	protected List<File> knowsFiles = new ArrayList<File>();
	protected int ctp;
	
	public PluginFinder(File dir){
		this.dir= dir;
		ctp =0;
		this.timer = new Timer(1000, this);
		
	}

	public List<File> listPluginClassFiles(){
		return Arrays.asList(dir.listFiles(filter));
	}
	
	public void actionPerformed(ActionEvent event){
		List<File> allFiles = this.listPluginClassFiles();
		for( File f: allFiles){
			if (this.knowsFiles.contains(f) && this.filter.accept(dir, f.getName())){
				for (PluginListener p:listeners){
					p.pluginAdded(f);
				}
				this.knowsFiles.add(f);
			}
		}
		for( File f: knowsFiles){
			if (allFiles.contains(f) && this.filter.accept(dir, f.getName())){
				for (PluginListener p:listeners){
					p.pluginRemoved(f);
				}
				this.knowsFiles.remove(f);
			}
		}
		knowsFiles = allFiles;
		System.out.println(ctp++);
	}
	
	public void addListener(PluginListener plugin){
		this.listeners.add(plugin);
	}
	
	public void removeListener(PluginListener plugin){
		this.listeners.remove(plugin);
	}
	
	public void start(){
		this.timer.start();
	}
	
	public void stop(){
		this.timer.stop();
	}
}
