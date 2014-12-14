package pe.almc.sbs.view.bean;

import java.util.ArrayList;
import java.util.List;






import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.almc.sbs.bean.Condicion;
import pe.almc.sbs.bean.Producto;
import pe.almc.sbs.bean.Region;
import pe.almc.sbs.bean.TipoProducto;
import pe.almc.sbs.service.SBSTasasFacade;


@Component
@ManagedBean
@SessionScoped
public class FormTasasBean {

	@Autowired
	private SBSTasasFacade sbsTasasFacade; 
	
	private String region;
	private String tipoProducto;
	private String codProducto;

	private String condicion;
	
	public List<Region> getListAllRegion(){
		return sbsTasasFacade.regionFindAll();
	}
	
	public TipoProducto[] getListTiposProducto(){
		return TipoProducto.values();
	}
		
	public List<Producto> getListProducto(){
		return sbsTasasFacade.productoFindByTipoprod(tipoProducto);
	}
	
	public List<Condicion> getListCondicion(){
		List<Condicion> resp = null;
		System.out.println("sssssssssss");
		if(codProducto!=null){
			Producto p = sbsTasasFacade.productoFindById(codProducto, tipoProducto);
			if(p != null){
				System.out.println("P: " + p.getLstCondiciones());
				resp = new ArrayList<Condicion>(p.getLstCondiciones());
				System.out.println("ddd" +  resp!=null?resp.size():"nulo");				
			}
			System.out.println("eee");
		}
		System.out.println("gggg");
		return resp;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

}
