package pe.almc.sbs.view.bean;

import junit.framework.TestCase;

import org.junit.Test;

public class MenuBuilderTestCase {

	
	@Test 
	public void testBuildMainMenu(){
		MenuBuilder menuBuilder = new MenuBuilder();
		
		TestCase.assertNotNull(menuBuilder.buildMainMenu());
		
	}
}
