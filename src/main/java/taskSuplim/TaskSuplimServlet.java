package taskSuplim;

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
import task.TaskDao;
import upper.info.UpperInfoBean;
import upper.info.UpperInfoDao;

 
 
@WebServlet("/task")
public class TaskSuplimServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TaskSuplimDao taskSuplimDao;
 
    public void init() {
    	taskSuplimDao = new TaskSuplimDao();
    }
 
    public TaskSuplimServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
 
        doPost(request,response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 
    	
    	
    	HttpSession session = request.getSession();
        session.setAttribute("id1", LoginServlet.userID); //ce dracu esti tu ???
        request.setAttribute("id2", LoginServlet.userID);
        
        List<TaskSuplimBean> task = new ArrayList<TaskSuplimBean>();
        try {
			task = TaskSuplimDao.viewTask();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        List<TaskSuplimBean> teamTask = new ArrayList<TaskSuplimBean>();
        try {
            teamTask = TaskSuplimDao.viewTeamTasks();
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        try {
			UpperInfoDao.info(LoginServlet.userID);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        request.setAttribute("nume",UpperInfoBean.getNume());
        request.setAttribute("job",UpperInfoBean.getJob());
        request.setAttribute("tip_user",UpperInfoBean.getTip_user());
        request.setAttribute("companie",UpperInfoBean.getCompanie());        
        
        request.setAttribute("taskList", task);
        request.setAttribute("teamTask", teamTask);

        
        request.getRequestDispatcher("task_suplim.jsp").forward(request, response);
        //response.sendRedirect("profile.jsp");
    	
    	
    	
    	
    	
//        try {
//            
//        	taskSuplimDao.viewTask();
//
//	        UpperInfoDao.info(LoginServlet.userID);
//            request.setAttribute("nume",UpperInfoBean.getNume());
//            request.setAttribute("job",UpperInfoBean.getJob());
//            request.setAttribute("tip_user",UpperInfoBean.getTip_user());
//            request.setAttribute("companie",UpperInfoBean.getCompanie());
//            //request.getRequestDispatcher("echipa.jsp").forward(request, response);
//            
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
 
        //response.sendRedirect("employees_management.jsp");
    }
}