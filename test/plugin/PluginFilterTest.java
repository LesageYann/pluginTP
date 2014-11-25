package plugin;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import plugins.CompatbileWithPlugin;
import plugins.notAPlugin;


public class PluginFilterTest {

	PluginFilter filter = new PluginFilter();
	
	@Test
	public void testEndsWithDotClass() {
		assertFalse(filter.endsWithDotClass( "testclass"));
		assertTrue(filter.endsWithDotClass("test.class"));
	}
	
	@Test
	public void testIsValidPluginClass(){
		assertTrue(filter.isValidPluginClass(PluginTest.class));
		assertTrue(filter.isValidPluginClass(CompatbileWithPlugin.class));
		assertFalse(filter.isValidPluginClass(notAPlugin.class));
	}
	
	@Test
	public void testAccept() {
		File file1= new File("/test/testclass");
		assertFalse(filter.accept(file1, "testclass"));
		assertTrue(filter.accept(file1, "PluginTest.class"));
	}
	
	

}
