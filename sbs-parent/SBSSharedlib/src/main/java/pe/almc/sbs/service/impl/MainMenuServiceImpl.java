package pe.almc.sbs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pe.almc.sbs.bean.MainMenu;
import pe.almc.sbs.repository.MainMenuRepository;
import pe.almc.sbs.service.MainMenuService;

@Service
public class MainMenuServiceImpl implements MainMenuService{
	private static Logger logger = LoggerFactory.getLogger(MainMenuServiceImpl.class);
	
	@Resource
	private MainMenuRepository mainMenuRepository;

	@Override
	public List<MainMenu> listParentsMenu() {
		logger.debug("Init listParentsMenu");
		List<MainMenu> listMenu = null;		
		listMenu = mainMenuRepository.findMenuParents();
		logger.debug("End listParentsMenu");
		return listMenu;
	}

	@Override
	public MainMenu findById(Integer code) {
		MainMenu menu = null;
		logger.debug("Init findById");
		menu = mainMenuRepository.findById(code);
		logger.debug("End findById");
		return menu;
	}

}
