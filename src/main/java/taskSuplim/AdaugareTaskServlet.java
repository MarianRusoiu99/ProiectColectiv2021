package taskSuplim;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.LoginServlet;
import profile.ProfileBean;
import profile.ProfileDao;
import upper.info.UpperInfoBean;
import upper.info.UpperInfoDao;

/**
 * Servlet implementation class AdaugareTask
 */
@WebServlet("/AdaugareTask")
public class AdaugareTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdaugareTaskDao adaugareTaskDao;
 
    public void init() {
    	adaugareTaskDao = new AdaugareTaskDao();
    }
 
    public AdaugareTaskServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().append("Served at: ").append(request.getContextPath());
 
        doPost(request,response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
 
        try {

                HttpSession session = request.getSession();
                session.setAttribute("id1", LoginServlet.userID); //ce dracu esti tu ???
                request.setAttribute("id2", LoginServlet.userID);
	            
                int id_task = Integer.parseInt(request.getParameter("id"));
                
                adaugareTaskDao.addTask(id_task);
	            
                response.sendRedirect("task");
                
                
                //response.sendRedirect("profile.jsp");
           
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        //response.sendRedirect("profile.jsp");
    }
}
