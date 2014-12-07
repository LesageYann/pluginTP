package model.plugin;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

public class PluginFilter implements FilenameFilter {

	private String filter;

	PluginFilter() {
		this.filter = ".class";
	}

	/**
	 * test if a plugin file is valid
	 * 
	 * @param dir
	 *            File
	 * @param filename
	 *            String
	 * @return true is the plugin is valid
	 */
	public boolean accept(File dir, String filename) {
		if (!this.endsWithDotClass(filename))
			return false;
		Class<?> theClass = this.getClass(filename);
		return this.isValidPluginClass(theClass)
				&& this.hasParameterLessConstructor(theClass)
				&& this.isInPluginPackage(theClass);
	}

	/**
	 * test if the plugin is in package plugins
	 * 
	 * @param theClass
	 * @return true if the package is "plugins"
	 */
	public boolean isInPluginPackage(Class<?> theClass) {
		return theClass.getPackage().getName().equals("plugins");
	}

	/**
	 * test if the plugin have the good number param for contructor
	 * 
	 * @param theClass
	 * @return true if the class have a constructor with none parameter
	 */
	public boolean hasParameterLessConstructor(Class<?> theClass) {
		for (Constructor<?> c : theClass.getConstructors()) {
			if (c.getParameterTypes().length == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * test if the plugin is a class
	 * 
	 * @param filename
	 * @return true if the filename is a class
	 */
	public Class<?> getClass(String filename) {
		try {
			return Class.forName("plugins."
					+ (filename.replaceAll("\\.class$", "")));
		} catch (ClassNotFoundException e) {
			throw new Error("Class not found");
		}
	}

	public boolean isValidPluginClass(Class<?> theClass) {

		return Plugin.class.isAssignableFrom(theClass);
	}

	public boolean endsWithDotClass(String arg1) {
		return arg1.endsWith(this.filter);
	}

}
