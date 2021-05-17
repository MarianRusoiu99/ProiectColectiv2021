package fileHandler;




import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.opencsv.CSVReader;

import employeeManagement.*;

import java.util.regex.*;


@WebServlet("/UploadDownloadFileServlet")
public class UploadDownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
    
    public List<AddEmployeeBean> employeelist = new ArrayList<AddEmployeeBean>();

    
	@Override
	public void init() throws ServletException{
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		if(fileName == null || fileName.equals("")){
			throw new ServletException("File Name can't be null or empty");
		}
		File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileName);
		if(!file.exists()){
			throw new ServletException("File doesn't exists on server.");
		}
		System.out.println("File location on server::"+file.getAbsolutePath());
		ServletContext ctx = getServletContext();
		InputStream fis = new FileInputStream(file);
		String mimeType = ctx.getMimeType(file.getAbsolutePath());
		response.setContentType(mimeType != null? mimeType:"application/octet-stream");
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		
		ServletOutputStream os = response.getOutputStream();
		byte[] bufferData = new byte[1024];
		int read=0;
		while((read = fis.read(bufferData))!= -1){
			os.write(bufferData, 0, read);
		}
		os.flush();
		os.close();
		fis.close();
		System.out.println("File downloaded at client successfully");
	}

	
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)){
			throw new ServletException("Content type is not multipart/form-data");
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><head></head><body>");
		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			while(fileItemsIterator.hasNext()){
				FileItem fileItem = fileItemsIterator.next();
				System.out.println("FieldName="+fileItem.getFieldName());
				System.out.println("FileName="+fileItem.getName());
				System.out.println("ContentType="+fileItem.getContentType());
				System.out.println("Size in bytes="+fileItem.getSize());
				
				File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileItem.getName());
				System.out.println("Absolute Path at server="+file.getAbsolutePath());
				fileItem.write(file);
				out.write("File "+fileItem.getName()+ " uploaded successfully.");
				out.write("<br>");
				
				try (CSVReader reader = new CSVReader(new FileReader(fileItem.getName()))) {
		            List<String[]> r = reader.readAll();
		            r.forEach(x -> {
		            	
		          //  System.out.println(x.toString());
		            Pattern date_pattern = Pattern.compile( "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])", Pattern.CASE_INSENSITIVE);
		            Matcher date_matcher = date_pattern.matcher(x[2]);
		            
		            Pattern email_pattern = Pattern.compile( "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		            Matcher email_matcher = email_pattern.matcher(x[6]);
		            
		            Pattern phone_pattern = Pattern.compile( "^\\d{10}$", Pattern.CASE_INSENSITIVE);
		            Matcher phone_matcher = phone_pattern.matcher(x[6]);
		            
		            
		            if(date_matcher.find()&&email_matcher.find()&&phone_matcher.find()) {
		            employeelist.add(new AddEmployeeBean(x[0],x[1],x[2],x[3],x[4],x[5],x[6],x[7]));
		            }
		            else {
		            	System.out.println("csv invalid");
		            }
		            
		            });
		            
				}
				//System.out.println(employeelist);
				AddEmployeeDao dao = new AddEmployeeDao(); 
		            
			        for(AddEmployeeBean i : employeelist) {
			        	//System.out.println(i);
			        	dao.addEmployee(i);
			        	//System.out.println(i);
			        }
			            
	
				/*
				List<List<String>> records = new ArrayList<List<String>>();
				try (CSVReader csvReader = new CSVReader(new FileReader(fileItem.getName()));) {
				    String[] values = null;
				    while ((values = csvReader.readNext()) != null) {
				        //	records.add(Arrays.asList(values));
				        System.out.println(Arrays.asList(values));
				        System.out.println(values[1].getClass()); 
				    }
				}
				
			     */
			    
				}
		} catch (FileUploadException e) {
			out.write("Exception in uploading file.");
		} catch (Exception e) {
			out.write("Exception in uploading file.");
		}
		
		response.sendRedirect("employees_management.jsp");
	//	request.setAttribute("Name",name);
		
		
		
		
		out.write("</body></html>");
		
		
	}

}
