package view;

import java.io.File;

import model.event.PluginLogger;
import model.event.PluginViewUpdater;
import model.plugin.PluginFinder;
import model.plugin.PluginModel;

public class Main {
	public static void main(String[] args) {
		File dir=new File("bin/plugins");
		PluginFinder finder = new PluginFinder(dir);
		PluginModel model = new PluginModel(finder);
		PluginFrame frame=new PluginFrame(model, "OP plugins here !");
		finder.addListener(new PluginViewUpdater(frame,model));
		finder.addListener(new PluginLogger());
		finder.start();
	}
}
