package pe.almc.sbs.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import pe.almc.common.MAGICNumber;

@Entity
@Table(schema="public")
@NamedQueries({
	@NamedQuery(name="MainMenu.findAll", query="SELECT m FROM MainMenu m"),
	@NamedQuery(name="MainMenu.findMenuParents", query="SELECT m FROM MainMenu m where m.padre IS NULL ORDER BY m.positionMenu ASC"),
	@NamedQuery(name="MainMenu.findById", query="SELECT m FROM MainMenu m where m.code = :code")
})
public class MainMenu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional=false)
	@Column(nullable=false, length=MAGICNumber.L8)	
	private Integer code;
	
	@Column(length=MAGICNumber.L50)
	private String label;
	
	@Column(length=MAGICNumber.L255)
	private String url;
	
	@Column(name="position_menu", length=MAGICNumber.L3)
	private Integer positionMenu;
	
	@Column(length=MAGICNumber.L255)
	private String icon;
	
	@Column(name="is_separator", length=MAGICNumber.L1)
	private String isSeparator;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="padre", fetch=FetchType.LAZY)
	@OrderBy("positionMenu ASC")
	private List<MainMenu> hijos;
	
	@ManyToOne
	@JoinColumn(name="parent_code", referencedColumnName="code", nullable=true)
	public MainMenu padre;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPositionMenu() {
		return positionMenu;
	}

	public void setPositionMenu(Integer positionMenu) {
		this.positionMenu = positionMenu;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIsSeparator() {
		return isSeparator;
	}

	public void setIsSeparator(String isSeparator) {
		this.isSeparator = isSeparator;
	}

	public List<MainMenu> getHijos() {
		return hijos;
	}

	public void setHijos(List<MainMenu> hijos) {
		this.hijos = hijos;
	}

	public MainMenu getPadre() {
		return padre;
	}

	public void setPadre(MainMenu padre) {
		this.padre = padre;
	}
	
	@Override
	public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
	}

}
