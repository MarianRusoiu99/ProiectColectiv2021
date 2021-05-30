package task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.LoginServlet;

/**
 * Servlet implementation class DoneServlet
 */
@WebServlet("/DoneServlet")
public class DoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private DoneDao doneDao;
 
    public void init() {
    	doneDao = new DoneDao();
    }   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

                HttpSession session = request.getSession();
                session.setAttribute("id1", LoginServlet.userID); //ce dracu esti tu ???
                request.setAttribute("id2", LoginServlet.userID);
	            
                int id_task = Integer.parseInt(request.getParameter("id"));
                String tip_task = request.getParameter("type");
                
                doneDao.doneTask(id_task,tip_task);
	            
                response.sendRedirect("userTask");
                
                
                //response.sendRedirect("profile.jsp");
           
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
	}

}

