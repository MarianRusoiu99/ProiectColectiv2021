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
 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/task_suplim.jsp");
        //????
        dispatcher.forward(request, response);
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
        
        request.setAttribute("numeTask1", task.get(0).getNumeTask());
        //System.out.println("NUME MEMBRU: " + task.get(0).getNumeTask());
        request.setAttribute("descriereTask1",task.get(0).getDescriereTask());
        //System.out.println("PRENUME MEMBRU: " + task.get(0).getDescriereTask());
        request.setAttribute("tehnologiiTask1",task.get(0).getTehnologiiTask());
        request.setAttribute("deadlineTask1",task.get(0).getDeadlineTask());
        request.setAttribute("repetitiveTask1",task.get(0).getRepetitiveTask());
        request.setAttribute("contactTask1",task.get(0).getContactTask());
        request.setAttribute("tipTask1",task.get(0).getTipTask());

        
        request.getRequestDispatcher("task_suplim.jsp").forward(request, response);
        //response.sendRedirect("profile.jsp");
    	
    	
    	
    	
    	
        try {
            
        	taskSuplimDao.viewTask();

	        UpperInfoDao.info(LoginServlet.userID);
            request.setAttribute("nume",UpperInfoBean.getNume());
            request.setAttribute("job",UpperInfoBean.getJob());
            request.setAttribute("tip_user",UpperInfoBean.getTip_user());
            request.setAttribute("companie",UpperInfoBean.getCompanie());
            //request.getRequestDispatcher("echipa.jsp").forward(request, response);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        //response.sendRedirect("employees_management.jsp");
    }
}