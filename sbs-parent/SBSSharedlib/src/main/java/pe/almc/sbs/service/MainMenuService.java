package pe.almc.sbs.service;

import java.util.List;

import pe.almc.sbs.bean.MainMenu;

public interface MainMenuService {

	List<MainMenu> listParentsMenu();

	MainMenu findById(Integer menu);

}
