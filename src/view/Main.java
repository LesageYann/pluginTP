package view;

import java.io.File;

import model.event.PluginLogger;
import model.event.PluginViewUpdater;
import model.plugin.PluginFinder;

public class Main {
	public static void main(String[] args) {
		File dir=new File("bin/plugins");
		PluginFinder finder = new PluginFinder(dir);
		PluginFrame f=new PluginFrame(finder, "OP plugins here !");
		System.out.println(f.mainPanel.getText());
		finder.addListener(new PluginViewUpdater(f));
		finder.addListener(new PluginLogger());
		finder.start();
	}
}
