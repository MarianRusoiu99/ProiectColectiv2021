package task;


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

import echipa.EchipaBean;
import echipa.EchipaDao;
import login.LoginServlet;
import taskSuplim.TaskSuplimBean;
import upper.info.UpperInfoBean;
import upper.info.UpperInfoDao;

 
 
@WebServlet("/userTask")
public class TaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TaskDao taskDao;
 
    public void init() {
    	taskDao = new TaskDao();
    }
 
    public TaskServlet() {
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
			task = TaskDao.viewTask();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        List<TaskSuplimBean> teamTask = new ArrayList<TaskSuplimBean>();
        try {
            teamTask = TaskDao.viewTeamTasks();
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        for(TaskSuplimBean x : teamTask) {
        	System.out.println("!!! " + x.getNumeTask());
        }
        
        List<TaskSuplimBean> completeTask = new ArrayList<TaskSuplimBean>();
        try {
            completeTask = TaskDao.viewCompleteTasks();
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
        request.setAttribute("completeTask", completeTask);

        
        request.getRequestDispatcher("taskuri.jsp").forward(request, response);
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