package plugin;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class PluginFilterTest {

	PluginFilter filter = new PluginFilter();
	
	@Test
	public void testEndsWithDotClass() {
		assertFalse(filter.endsWithDotClass( "testclass"));
		assertTrue(filter.endsWithDotClass("test.class"));
	}
	
	@Test
	public void testIsValidPluginClass(){
		assertTrue(filter.isValidPluginClass(plugin.class));
		assertTrue(filter.isValidPluginClass(compatibleWithPlugin.class));
		assertFalse(filter.isValidPluginClass(NotAPlugin.class));
	}
	
	@Test
	public void testAccept() {
		File file1= new File("/test/testclass");
		assertFalse(filter.accept(file1, "testclass"));
		assertTrue(filter.accept(file1, "test.class"));
	}
	
	

}
