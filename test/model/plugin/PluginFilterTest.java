package model.plugin;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import model.plugin.PluginFilter;

import org.junit.Test;


public class PluginFilterTest {

	PluginFilter filter = new PluginFilter();
	
	@Test
	public void testEndsWithDotClass() {
		assertFalse(filter.endsWithDotClass( "testclass"));
		assertTrue(filter.endsWithDotClass("test.class"));
	}
	
	@Test
	public void isInPluginPackageTest() throws ClassNotFoundException{
		Class<?> pluginTest = filter.getClass("PluginTest.class");
		assertTrue(filter.isInPluginPackage(pluginTest));
		Class<?> filter2 =Class.forName("model.plugin.PluginFilter");
		assertFalse(filter.isInPluginPackage(filter2));
	}
	
	@Test
	public void testIsValidPluginClass(){
		Class<?> pluginTest = filter.getClass("PluginTest.class");
		assertTrue(filter.isValidPluginClass(pluginTest));
		Class<?> notAPlugin = filter.getClass("notAPlugin.class");
		assertFalse(filter.isValidPluginClass(notAPlugin));
	}
	
	@Test
	public void testAccept() {
		File file1= new File("/test/testclass");
		assertFalse(filter.accept(file1, "testclass"));
		assertTrue(filter.accept(file1, "PluginTest.class"));
	}
	
	

}
