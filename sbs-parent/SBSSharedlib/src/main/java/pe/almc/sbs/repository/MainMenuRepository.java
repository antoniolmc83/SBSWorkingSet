package pe.almc.sbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import pe.almc.sbs.bean.MainMenu;

public interface MainMenuRepository extends JpaRepository<MainMenu, Integer>{

	List<MainMenu> findAll();
	List<MainMenu> findMenuParents();
	MainMenu findById(@Param("code")Integer code);

}
