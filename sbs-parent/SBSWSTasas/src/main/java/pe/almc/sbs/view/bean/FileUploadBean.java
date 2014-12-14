package pe.almc.sbs.view.bean;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

/**
 * 
 * @author ALMC
 *
 */
@ManagedBean
@SessionScoped
public class FileUploadBean implements Serializable {

	private List<UploadedImage> files = new ArrayList<UploadedImage>();
	private String fileName;
	
	public void listener(FileUploadEvent event) throws Exception{
		UploadedFile item = event.getUploadedFile();
		UploadedImage file = new UploadedImage();
        file.setLength(item.getData().length);
        file.setName(item.getName());
        file.setData(item.getData());
        files.add(file);
        
        System.out.println("Totoal: " + files.size());
	}
	
	public void paint( OutputStream stream, Object object) throws IOException{
		stream.write( getFiles().get((Integer)object).getData() );
		stream.close();
	}
			
	/**
	 * clears on file from the actual uploaded (but not yet saved) files. The
	 * current selected filename is assigned by an a4j:actionparam to the
	 * property 'fileName'; If filename==null all uploaded files will be removed
	 * 
	 * @see https://community.jboss.org/message/537903#537903
	 * @return
	 */
	public void clearUploadData() {
		try {
			// test if a single file was cleared....
			if (fileName != null && !"".equals(fileName)) {
				System.out.println("Removing single fileName=" + fileName);
				files.remove(fileName);
			}
			else {
				files.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public int getSize(){
		if( getFiles().size() > 0 ){
			return getFiles().size();
		}else{
			return 0;
		}
	}
	
	
	public long getTimeStamp(){
		return System.currentTimeMillis();
	}

	public List<UploadedImage> getFiles() {
		return files;
	}

	public void setFiles(List<UploadedImage> files) {
		this.files = files;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		System.out.println("Filname is updates:" + fileName);
		this.fileName = fileName;
	}
	
}
