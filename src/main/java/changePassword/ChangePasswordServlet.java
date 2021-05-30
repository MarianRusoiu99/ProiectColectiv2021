package changePassword;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.LoginServlet;
import upper.info.UpperInfoBean;
import upper.info.UpperInfoDao;
 
 
 
@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ChangePasswordDao changePasswordDao;
 
    public void init() {
    	changePasswordDao = new ChangePasswordDao();
    }
 
    public ChangePasswordServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/changePassword.jsp");
        //????
        dispatcher.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    	
        String newPass = request.getParameter("password");
        
 
        ChangePasswordBean password = new ChangePasswordBean();
        
        password.setNewPass(newPass);        
        
        
        try {
            
        	changePasswordDao.changePass(password);

	        UpperInfoDao.info(LoginServlet.userID);
            request.setAttribute("nume",UpperInfoBean.getNume());
            request.setAttribute("job",UpperInfoBean.getJob());
            request.setAttribute("tip_user",UpperInfoBean.getTip_user());
            request.setAttribute("companie",UpperInfoBean.getCompanie());
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}