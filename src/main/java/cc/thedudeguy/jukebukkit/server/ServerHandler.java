package cc.thedudeguy.jukebukkit.server;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import cc.thedudeguy.jukebukkit.JukeBukkit;
import cc.thedudeguy.jukebukkit.util.Debug;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class ServerHandler extends AbstractHandler {

	public Configuration cfg;
	
	public ServerHandler() {
		cfg = new Configuration();
		try {
			cfg.setDirectoryForTemplateLoading( new File(JukeBukkit.instance.getDataFolder(), "web") );
			cfg.setObjectWrapper(new DefaultObjectWrapper());  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void handle(
				String target,
				Request baseRequest, 
				HttpServletRequest request,
				HttpServletResponse response
			) throws IOException, ServletException {
		
		Debug.debug("Handling Web Request: ", target);
		
		if ( target.equalsIgnoreCase("/") ) {
			
			response.setContentType("text/html;charset=utf-8");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			
			Template template = cfg.getTemplate("index.html");
			
			Map<String, Object> dataRoot = new HashMap<String, Object>();
			dataRoot.put("serverName", JukeBukkit.instance.getConfig().getString("serverName"));
			dataRoot.put("allowUpload", JukeBukkit.instance.getConfig().getBoolean("allowWebServerUploads"));
			
			dataRoot.put("files", JukeBukkit.getServerFileList());
			
			try {
				template.process(dataRoot, response.getWriter());
			} catch (TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return;
		}
		
		
		if ( target.equalsIgnoreCase("/upload") ) {
			
			if (!JukeBukkit.instance.getConfig().getBoolean("allowWebServerUploads")) {
				return;
			}
			
			response.setContentType("text/html;charset=utf-8");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			
			if (!ServletFileUpload.isMultipartContent(request))
			{
				response.getWriter().println("No File Upload Detected");
				return;
			}
			
			
			/* Straight from commons.io docs */
			
			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();
			
			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			// Parse the request
			try {
				
				List<FileItem> items = castList(FileItem.class, upload.parseRequest(request));
				
				// Process the uploaded items
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
				    FileItem item = (FileItem) iter.next();

				    if (item.isFormField()) {
				        //processFormField(item);
				    } else {
				        //processUploadedFile(item);
				    	//String fieldName = item.getFieldName();
				        //String fileName = item.getName();
				        //String contentType = item.getContentType();
				        //boolean isInMemory = item.isInMemory();
				        //long sizeInBytes = item.getSize();
				        
				    	if (!item.getName().endsWith(".ogg") && !item.getName().endsWith(".wav") && !item.getName().endsWith(".mp3")) {
				    		response.getWriter().println("File must be a .ogg or .wave");
				    		return;
				    	}
				    	
				    	String name = item.getName().replace(" ", "_");
				    	File uploadedFile = new File(JukeBukkit.instance.getDataFolder(), "music/"+name);
				        item.write(uploadedFile);
				        
				        response.getWriter().println("1");
				        return;
				    }
				}
				
			} catch (FileUploadException e) {
				response.getWriter().println(e.getMessage());
				return;
			} catch (Exception e) {
				response.getWriter().println(e.getMessage());
				return;
			}
	        
	        return;
		}
		
	}
	
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
}
