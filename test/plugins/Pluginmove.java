package plugins;

import model.plugin.Plugin;

public class Pluginmove implements Plugin {


	@Override
	public String transform(String s) {
		return "result for all string";
	}

	@Override
	public String getLabel() {
		return "plugin test label"; 
	}

}
