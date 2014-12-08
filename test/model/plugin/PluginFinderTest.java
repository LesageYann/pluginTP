package model.plugin;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import model.event.PluginListenerTest;

import org.junit.Test;

public class PluginFinderTest {

	public void filecopy(String inName, String outName){
		FileChannel in = null; // canal d'entr�e
		FileChannel out = null; // canal de sortie
	 
		try {
			in = new FileInputStream(inName).getChannel();
			out = new FileOutputStream(outName).getChannel();
	 
			// Copie depuis le in vers le out
			in.transferTo(0, in.size(), out);
		} catch (Exception e) {
			e.printStackTrace(); // n'importe quelle exception
		} finally { // finalement on ferme
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {}
			}
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {}
			}
		}
	}

	@Test
	public void testActionPerformed() {
		filecopy("bin/pluginsTest/Pluginmove.class","bin/plugins/Pluginmove.class");
		PluginFinder finder = new PluginFinder(new File("bin/plugins"));
		PluginListenerTest finderTest= new PluginListenerTest();
		finder.addListener(finderTest);
		finder.start();
		//on teste si les fichier sont ajouter
		// wait to add plugin
		try {
			Thread.sleep(36000);
		} catch (InterruptedException e) {
			fail();
		}
		assertTrue(finderTest.haveAdded());
		assertFalse(finderTest.haveRemove());
		// wait to remove plugin
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			fail();
		}
		finder.stop();
		assertTrue(finderTest.haveRemove());
	}
	
	/*
	 * @Test
	public void testActionPerformed() {
		PluginFinder finder = new PluginFinder(new File("bin/plugins"));
		PluginListenerTest finderTest= new PluginListenerTest();
		finder.addListener(finderTest);
		finder.start();
		//on teste si les fichier sont ajouter
		File source = new File("bin/pluginsTest/Pluginmove.class");
		File destination = new File("bin/plugins/Pluginmove.class");
		source.renameTo(destination);
		// wait to add plugin
		try {
			Thread.sleep(36000);
		} catch (InterruptedException e) {
			fail();
		}
		//new move to not throw "Exception in thread "AWT-EventQueue-0" java.lang.NoClassDefFoundError: plugins/Pluginmove (wrong name: pluginsTest/Pluginmove)"
		destination.renameTo(source);
		
		assertTrue(finderTest.haveAdded());
		assertFalse(finderTest.haveRemove());
		// wait to remove plugin
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			fail();
		}
		finder.stop();
		assertTrue(finderTest.haveRemove());
	}*/

}
