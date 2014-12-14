package pe.almc.sbs.view.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;

import org.richfaces.component.AbstractDropDownMenu.Facets;
import org.richfaces.component.UIDropDownMenu;
import org.richfaces.component.UIMenuItem;
import org.richfaces.component.UIToolbar;
import org.springframework.stereotype.Component;


@Component
@ManagedBean(eager=true)
@RequestScoped
public class MainMenuBean {
	
	private UIToolbar uiToolBar;
	
	public MainMenuBean() {
		
	}
	
	
	private UIMenuItem buildUIMenuItem(String textLabel){
		UIMenuItem uiMenuItem = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		uiMenuItem = (UIMenuItem)ctx.getApplication().createComponent(ctx, UIMenuItem.COMPONENT_TYPE, "org.richfaces.renderkit.html.MenuItemRenderer");
		uiMenuItem.setLabel(textLabel);
		uiMenuItem.setId("id"+textLabel);
		
		return uiMenuItem;
	}
	
	private UIDropDownMenu buildUIDropDownMenu(String textLabel){
		UIDropDownMenu uiDropDownMenu = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		uiDropDownMenu = (UIDropDownMenu) ctx.getApplication().createComponent(ctx, UIDropDownMenu.COMPONENT_TYPE, "org.richfaces.renderkit.html.DropDownMenuRenderer");
		
		HtmlOutputText label = (HtmlOutputText)ctx.getApplication().createComponent(HtmlOutputText.COMPONENT_TYPE);
		label.setValue(textLabel);
		uiDropDownMenu.getFacets().put(Facets.label.name(), label);
		uiDropDownMenu.setId("id"+textLabel);
		
		uiDropDownMenu.getChildren().add(buildUIMenuItem("New"));
		
		return uiDropDownMenu;
	}
	
	/**
	 * Build a UIToolBar
	 */
	private void createUIToolBar(){
		System.out.println("createUIToolBar");
		FacesContext ctx = FacesContext.getCurrentInstance();
		uiToolBar = (UIToolbar) ctx.getApplication().createComponent(ctx, UIToolbar.COMPONENT_TYPE, "org.richfaces.renderkit.html.ToolbarRenderer");		
		uiToolBar.getChildren().add(buildUIDropDownMenu("File"));
		uiToolBar.setId("idMainToolBar");
		
	}


	public UIToolbar getUiToolBar() {
		if( uiToolBar == null )createUIToolBar();
		return uiToolBar;
	}


	public void setUiToolBar(UIToolbar uiToolBar) {
		this.uiToolBar = uiToolBar;		
	}

 

}
