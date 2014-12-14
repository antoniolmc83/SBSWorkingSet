package pe.almc.sbs.view.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

@Component
@ManagedBean(name="searchEF")
@SessionScoped
public class SearchEntFinBean {

	
	public String doLoad(){
		return "efsearch.jsf?faces-redirect=true";
	}
}
