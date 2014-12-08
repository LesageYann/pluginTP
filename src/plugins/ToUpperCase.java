package plugins;

import model.plugin.Plugin;

public class ToUpperCase implements Plugin {

	@Override
	public String transform(String s) { 
		return s.toUpperCase();
	}

	@Override
	public String getLabel() {
		return "To upper case";

	}

}
