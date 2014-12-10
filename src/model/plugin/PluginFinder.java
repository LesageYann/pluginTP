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
	protected PluginFilter filter;
	protected Timer timer;
	protected List<PluginListener> listeners;
	protected List<File> knowsFiles;

	public PluginFinder(File dir) {
		this.dir = dir;
		this.timer = new Timer(1000, this);
		filter = new PluginFilter();
		listeners = new ArrayList<PluginListener>();
		knowsFiles = new ArrayList<File>();
	}

	public List<File> listPluginClassFiles() {
		return Arrays.asList(dir.listFiles(filter));
	}

	public void actionPerformed(ActionEvent event) {
		List<File> allFiles = this.listPluginClassFiles();
		for (File f : allFiles) {
			if (!this.knowsFiles.contains(f)
					&& this.filter.accept(dir, f.getName())) {
				Plugin plugin;
				try {
					plugin = (Plugin) filter.getClass(f.getName())
							.newInstance();
					for (PluginListener p : listeners) {
						p.pluginAdded(plugin);
					}
					this.knowsFiles.add(f);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		for (File f : knowsFiles) {
			if (!allFiles.contains(f) && this.filter.accept(dir, f.getName())) {
				Plugin plugin;
				try {
					plugin = (Plugin) filter.getClass(f.getName())
							.newInstance();
					for (PluginListener p : listeners) {
						p.pluginRemoved(plugin);
					}
					allFiles.remove(f);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		knowsFiles = allFiles;
	}

	public void addListener(PluginListener plugin) {
		this.listeners.add(plugin);
	}

	public void removeListener(PluginListener plugin) {
		this.listeners.remove(plugin);
	}

	public void start() {
		this.timer.start();
	}

	public void stop() {
		this.timer.stop();
	}
}
