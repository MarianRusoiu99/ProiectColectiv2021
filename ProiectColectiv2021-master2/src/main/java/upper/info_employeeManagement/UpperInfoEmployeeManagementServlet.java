package upper.info_employeeManagement;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UpperInfoEmployeeManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UpperInfoEmployeeManagementDao upperinfodao;
 
    public void init() {
    	upperinfodao = new UpperInfoEmployeeManagementDao();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    	request.setAttribute("nume",UpperInfoEmployeeManagementBean.getNume());
    	System.out.println(request.getAttribute("nume"));
    	request.setAttribute("job",UpperInfoEmployeeManagementBean.getJob());
    	System.out.println(request.getAttribute("job"));
    	request.setAttribute("tip_user",UpperInfoEmployeeManagementBean.getTip_user());
    	System.out.println(request.getAttribute("tip_user"));
    	System.out.println("hellooo");
    	
    }
}