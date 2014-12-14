package pe.almc.sbs.view.bean;

import javax.annotation.Resource;

import org.richfaces.component.UIDropDownMenu;

import pe.almc.sbs.service.MainMenuService;

public class MenuBuilder {
	
	@Resource
	private MainMenuService mainMenuService;
		

	public UIDropDownMenu buildMainMenu(){
		UIDropDownMenu dropDownMenu = new UIDropDownMenu();
		//Get level 0 menu
		
		
		//With each one build a dropDownMenu
		//With each one	
		return dropDownMenu;
	}
	
	 

}
