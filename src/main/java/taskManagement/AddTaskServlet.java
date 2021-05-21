package taskManagement;


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

 
 
 
@WebServlet("/addTask")
public class AddTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AddTaskDao addTaskDao;
 
    public void init() {
        addTaskDao = new AddTaskDao();
    }
 
    public AddTaskServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/tasks_management.jsp");
        //????
        dispatcher.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 
    	List<String> tehnologii = new ArrayList<String>();
    	
        String numeTask = request.getParameter("numeTask");
        String descriereTask = request.getParameter("descriereTask");
        String deadlineTask = request.getParameter("deadlineTask");
        String tipTask = request.getParameter("tipTask");
        String repetitive = request.getParameter("repetitive");
        tehnologii.add(request.getParameter("tehnologiiTask1"));
        tehnologii.add(request.getParameter("tehnologiiTask2"));
        tehnologii.add(request.getParameter("tehnologiiTask3"));
        tehnologii.add(request.getParameter("tehnologiiTask4"));
        tehnologii.add(request.getParameter("tehnologiiTask5"));
        //String slaTask = request.getParameter("slaTask");
 
        AddTaskBean task = new AddTaskBean();
        
        task.setNumeTask(numeTask);
        task.setDescriereTask(descriereTask);
        task.setTehnologii(tehnologii);
        task.setDeadlineTask(deadlineTask);
        task.setTipTask(tipTask);
        task.setRepetitive(repetitive);
        
        
        try {
            
        	addTaskDao.addTask(task);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        response.sendRedirect("tasks_management.jsp");
    }
}
