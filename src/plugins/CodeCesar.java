package plugins;

import model.plugin.Plugin;

public class CodeCesar implements Plugin {

	@Override
	public String transform(String s) {
		String result ="";
		for(int i=0;i<s.length();++i)
			result += (char) (s.charAt(i) + 5);
		return result;
	}

	@Override
	public String getLabel() {
		return "Code Cesar";
	}
	
	public String toString(){
		return this.getLabel();
	}

}
