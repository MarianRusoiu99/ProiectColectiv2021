package employeeManagement;


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
//import employeeManagement.AddEmployeeBean;
import upper.info_employeeManagement.UpperInfoEmployeeManagementBean;
import upper.info_employeeManagement.UpperInfoEmployeeManagementDao;
 
 
 
@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AddEmployeeDao addEmployeeDao;
 
    public void init() {
        addEmployeeDao = new AddEmployeeDao();
    }
 
    public AddEmployeeServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employees_management.jsp");
        //????
        dispatcher.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 
    	List<String> skills = new ArrayList<String>();
    	
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDate = request.getParameter("birthDate");
        String sex = request.getParameter("sex");
        String job = request.getParameter("job");
        skills.add(request.getParameter("skills1"));
        skills.add(request.getParameter("skills2"));
        skills.add(request.getParameter("skills3"));
        skills.add(request.getParameter("skills4"));
        skills.add(request.getParameter("skills5"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
 
        AddEmployeeBean employee = new AddEmployeeBean();
        
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setBirthDate(birthDate);
        employee.setSex(sex);
        employee.setJob(job);
        employee.setSkills(skills);
        employee.setEmail(email);
        employee.setPhone(phone);
        
        
        try {
            
        	addEmployeeDao.addEmployee(employee);

	        UpperInfoDao.info(LoginServlet.userID);
            request.setAttribute("nume",UpperInfoBean.getNume());
            request.setAttribute("job",UpperInfoBean.getJob());
            request.setAttribute("tip_user",UpperInfoBean.getTip_user());
            request.setAttribute("companie",UpperInfoBean.getCompanie());
            request.getRequestDispatcher("employees_management.jsp").forward(request, response);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        //response.sendRedirect("employees_management.jsp");
    }
}