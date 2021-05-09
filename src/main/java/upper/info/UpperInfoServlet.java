package upper.info;
 
import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import login.LoginBean;
import login.LoginDao;
import login.LoginServlet;
import registration.EmployeeBean;
 
 
@WebServlet("/upperInfo")
public class UpperInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UpperInfoDao upperinfodao;
 
    public void init() {
    	upperinfodao = new UpperInfoDao();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		String button = request.getParameter("button");
 
			UpperInfoDao.info(LoginServlet.userID);
			//System.out.println("UPPERINFO");
			if ("profil".equals(button)) {
		request.setAttribute("nume",UpperInfoBean.getNume());
        request.setAttribute("job",UpperInfoBean.getJob());
        request.setAttribute("tip_user",UpperInfoBean.getTip_user());
        request.setAttribute("companie",UpperInfoBean.getCompanie());
        request.getRequestDispatcher("profile.jsp").forward(request, response);
        }else if("taskuri".equals(button)) {
        	request.setAttribute("nume",UpperInfoBean.getNume());
            request.setAttribute("job",UpperInfoBean.getJob());
            request.setAttribute("tip_user",UpperInfoBean.getTip_user());
            request.setAttribute("companie",UpperInfoBean.getCompanie());
            request.getRequestDispatcher("taskuri.jsp").forward(request, response);
        }else if("employees_management".equals(button)) {
        	request.setAttribute("nume",UpperInfoBean.getNume());
            request.setAttribute("job",UpperInfoBean.getJob());
            request.setAttribute("tip_user",UpperInfoBean.getTip_user());
            request.setAttribute("companie",UpperInfoBean.getCompanie());
            request.getRequestDispatcher("employees_management.jsp").forward(request, response);
        }
 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
 
    }
}