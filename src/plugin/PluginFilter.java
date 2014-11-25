package plugin;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

public class PluginFilter  implements FilenameFilter {
	
	private String filter;

	PluginFilter(){
		this.filter=".class";
	}
	
	@Override
	public boolean accept(File dir, String filename) {
		if(!this.endsWithDotClass(filename)) return false;
		Class<?> theClass= this.getClass(filename);
		return this.isValidPluginClass(theClass)
				&& this.hasParameterLessConstructor(theClass)
				&& this.isInPluginPackage(theClass);
	}

	private boolean isInPluginPackage(Class<?> theClass) {
		return theClass.getPackage().getName()=="plugins";
	}

	private boolean hasParameterLessConstructor(Class<?> theClass) {
		for(Constructor<?> c : theClass.getConstructors()){
			if (c.getParameterTypes().length ==0){
				return true;
			}
		}
		return false;
	}

	private Class<?> getClass(String filename) {
		try{
			return Class.forName("plugins."+(filename.replace("\\.class$", filename)));
		}catch (ClassNotFoundException e){
			throw new Error("Class not found");
		}
	}

	private boolean isValidPluginClass(Class<?> theClass) {
		
		return Plugin.class.isAssignableFrom(theClass);
	}

	public boolean endsWithDotClass(String arg1) {
		return arg1.endsWith(this.filter);
	}


}
