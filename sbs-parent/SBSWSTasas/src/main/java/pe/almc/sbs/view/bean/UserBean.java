package pe.almc.sbs.view.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Size;

@ManagedBean
public class UserBean {

	@Size(min=3, max=12,message="Must be between 3 and 12 chars")
	private String name;
	private String state;
	
	
    public List<String> autocomplete(String prefix) {

        List<String> result = new ArrayList<String>();
        result.add("England");
        result.add("France");
        result.add("Germany");
        result.add("Italy");
        result.add("Spain");

        return result;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
