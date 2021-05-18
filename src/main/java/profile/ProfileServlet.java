package profile;

import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.LoginBean;
import login.LoginServlet;
import upper.info.UpperInfoBean;
import upper.info.UpperInfoDao;

 
 
 
@WebServlet("/Profile")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProfileDao profileDao;
 
    public void init() {
        profileDao = new ProfileDao();
    }
 
    public ProfileServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
        //????
        dispatcher.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 
        try {

                HttpSession session = request.getSession();
                session.setAttribute("id1", LoginServlet.userID); //ce dracu esti tu ???
                request.setAttribute("id2", LoginServlet.userID);
	            
	            ProfileBean profile = new ProfileBean();
	            try {
	    			profile = ProfileDao.setProfile();
	    		} catch (ClassNotFoundException e1) {
	    			// TODO Auto-generated catch block
	    			e1.printStackTrace();
	    		}
	            
                UpperInfoDao.info(LoginServlet.userID);
                request.setAttribute("nume",UpperInfoBean.getNume());
                request.setAttribute("job",UpperInfoBean.getJob());
                request.setAttribute("tip_user",UpperInfoBean.getTip_user());
                request.setAttribute("companie",UpperInfoBean.getCompanie());
                request.setAttribute("last_name", profile.getLastName());
                	System.out.println("FIRST NAME: " + ProfileBean.getLastName());
                request.setAttribute("first_name",profile.getFirstName());
                request.setAttribute("job2",profile.getJob());
                request.setAttribute("sex",profile.getSex());
                request.setAttribute("birth_date",profile.getBirthDate());
                request.setAttribute("email",profile.getEmail());
                request.setAttribute("phone",profile.getPhone());
                request.getRequestDispatcher("profile.jsp").forward(request, response);
                //response.sendRedirect("profile.jsp");
           
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        //response.sendRedirect("profile.jsp");
    }
}
