package login;

import java.io.IOException;
//import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import profile.ProfileBean;
import profile.ProfileDao;
import upper.info.UpperInfoBean;
import upper.info.UpperInfoDao;
 
/**
 * @email Ramesh Fadatare
 */
 
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;
    private ProfileDao profileDao;
    public static Integer userID = null;
 
    public void init() {
        loginDao = new LoginDao();
        profileDao = new ProfileDao();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setEmail(email);
        loginBean.setPassword(password);
        
        //ArrayList<String> data = new ArrayList<String>();
 
        try {
            if (loginDao.validate(loginBean)!=0) {
                HttpSession session = request.getSession();
                session.setAttribute("id1",loginDao.validate(loginBean)); //ce dracu esti tu ???
                request.setAttribute("id2",loginDao.validate(loginBean));
	                System.out.println(loginDao.validate(loginBean));
	                System.out.println(request.getAttribute("id2"));
	                
	            userID = loginDao.validate(loginBean);
	            
	            ProfileBean profile = new ProfileBean();
	            try {
	    			profile = ProfileDao.setProfile();
	    		} catch (ClassNotFoundException e1) {
	    			// TODO Auto-generated catch block
	    			e1.printStackTrace();
	    		}
	            
                UpperInfoDao.info((Integer)request.getAttribute("id2"));
                request.setAttribute("nume",UpperInfoBean.getNume());
                request.setAttribute("job",UpperInfoBean.getJob());
                request.setAttribute("tip_user",UpperInfoBean.getTip_user());
                request.setAttribute("companie",UpperInfoBean.getCompanie());
                request.setAttribute("last_name", profile.getLastName());
                	//System.out.println("FIRST NAME: " + ProfileBean.getLastName());
                request.setAttribute("first_name",profile.getFirstName());
                request.setAttribute("job2",profile.getJob());
                request.setAttribute("sex",profile.getSex());
                request.setAttribute("birth_date",profile.getBirthDate());
                request.setAttribute("email",profile.getEmail());
                request.setAttribute("phone",profile.getPhone());
                request.getRequestDispatcher("profile.jsp").forward(request, response);
                //response.sendRedirect("profile.jsp");
            } else {
                //HttpSession session = request.getSession();
                response.sendRedirect("login.jsp");
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}