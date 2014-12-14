package pe.almc.sbs.service;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.almc.sbs.bean.MainMenu;

public class MainMenuServiceTestCase {

	private MainMenuService mainMenuService;
	
	public MainMenuServiceTestCase() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		mainMenuService = applicationContext.getBean(MainMenuService.class);
	}
	
	@Test
	public void testFindById(){
		MainMenu  menu = mainMenuService.findById(5);
		TestCase.assertEquals("Save As...", menu.getLabel());
	}
	
	@Test
	public void testParentsMenu(){
		List<MainMenu> listMenu = null;		
		listMenu = mainMenuService.listParentsMenu();
		TestCase.assertEquals(2, listMenu.size());
		
		TestCase.assertEquals("File", listMenu.get(0).getLabel());
		TestCase.assertEquals("Link", listMenu.get(1).getLabel());
	}
	
	@Test
	public void testChildMenu1(){
		List<MainMenu> listMenu = null;
		listMenu = mainMenuService.listParentsMenu();
		
		MainMenu m = listMenu.get(0);
		TestCase.assertEquals("New", m.getHijos().get(0).getLabel());
		TestCase.assertEquals("Open", m.getHijos().get(1).getLabel());
		TestCase.assertEquals("Save As...", m.getHijos().get(2).getLabel());
		TestCase.assertEquals("Close", m.getHijos().get(3).getLabel());
		TestCase.assertEquals("T", m.getHijos().get(4).getIsSeparator());
		TestCase.assertEquals("Exit", m.getHijos().get(5).getLabel());		
	}
	
	@Test
	public void testChildMenu2(){
		List<MainMenu> listMenu = null;
		listMenu = mainMenuService.listParentsMenu();
		
		MainMenu m = listMenu.get(1);
		TestCase.assertEquals("RichFaces Home Page", m.getHijos().get(0).getLabel());
		TestCase.assertEquals("RichFaces Forum", m.getHijos().get(1).getLabel());	
	}
	
	@Test
	public void testIdentifyParents(){
		List<MainMenu> listMenu = null;
		listMenu = mainMenuService.listParentsMenu();
		
		MainMenu m = listMenu.get(0);
		TestCase.assertEquals(false, m.getHijos().get(0).getHijos().size()>0);
		TestCase.assertEquals(false, m.getHijos().get(1).getHijos().size()>0);
		TestCase.assertEquals(true, m.getHijos().get(2).getHijos().size()>0);
		TestCase.assertEquals(false, m.getHijos().get(3).getHijos().size()>0);
		TestCase.assertEquals(false, m.getHijos().get(4).getHijos().size()>0);
		TestCase.assertEquals(false, m.getHijos().get(5).getHijos().size()>0);
	}
	
	
	
}
