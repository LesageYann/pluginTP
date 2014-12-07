package view;

import java.io.File;

import model.plugin.PluginFinder;

public class Main {
	public static void main(String[] args) {
		File dir=new File("bin/plugins");
		PluginFinder finder = new PluginFinder(dir);
		finder.start();
		new PluginFrame(finder, "OP plugins here !");
	}
}
