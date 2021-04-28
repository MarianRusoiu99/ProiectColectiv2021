package upper.info;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.LoginBean;
import login.LoginDao;
import registration.EmployeeBean;

public class UpperInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UpperInfoDao upperinfodao;
 
    public void init() {
    	upperinfodao = new UpperInfoDao();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    	request.setAttribute("nume",UpperInfoBean.getNume());
    	System.out.println(request.getAttribute("nume"));
    	request.setAttribute("job",UpperInfoBean.getJob());
    	System.out.println(request.getAttribute("job"));
    	request.setAttribute("tip_user",UpperInfoBean.getTip_user());
    	System.out.println(request.getAttribute("tip_user"));
    	System.out.println("hellooo");
    	
    }
}
