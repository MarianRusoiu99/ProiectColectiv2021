package employeeManagement;


import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import employeeManagement.AddEmployeeBean;
import upper.info_employeeManagement.UpperInfoEmployeeManagementBean;
import upper.info_employeeManagement.UpperInfoEmployeeManagementDao;
 
 
 
@WebServlet("/editEmployee")
public class EditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EditEmployeeDao editEmployeeDao;
 
    public void init() {
        editEmployeeDao = new EditEmployeeDao();
    }
 
    public EditEmployeeServlet() {
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
 
    	
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDate = request.getParameter("birthDate");
        String sex = request.getParameter("sex");
        String job = request.getParameter("job");
        String email = request.getParameter("email");
        //String company = request.getParameter("company");
        //String position = request.getParameter("position");
        String phone = request.getParameter("phone");
        //String password = request.getParameter("password");
 
        AddEmployeeBean employee = new AddEmployeeBean();
        
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setBirthDate(birthDate);
        employee.setSex(sex);
        employee.setJob(job);
        employee.setEmail(email);
        //employee.setCompany(company);
        //employee.setPosition(position);
        employee.setPhone(phone);
        //employee.setPassword(password);
        
        
        try {
            
        	editEmployeeDao.editEmployee(employee);
            
        	
//        	if(addEmployeeDao.validate(employee)!=0) {
//        		
//        		HttpSession session = request.getSession();
//                session.setAttribute("id1",addEmployeeDao.validate(employee)); //ce dracu esti tu ???
//                request.setAttribute("id2",addEmployeeDao.validate(employee));
//	                System.out.println(addEmployeeDao.validate(employee));
//	                System.out.println(request.getAttribute("id2"));
//	                UpperInfoEmployeeManagementDao.info((Integer)request.getAttribute("id2"));
//                request.setAttribute("nume",UpperInfoEmployeeManagementBean.getNume());
//                request.setAttribute("job",UpperInfoEmployeeManagementBean.getJob());
//                request.setAttribute("tip_user",UpperInfoEmployeeManagementBean.getTip_user());
//                request.setAttribute("companie",UpperInfoEmployeeManagementBean.getCompanie());
//                request.getRequestDispatcher("employees_management.jsp").forward(request, response);
//                //response.sendRedirect("profile.jsp");
//            } else {
//                //HttpSession session = request.getSession();
//                response.sendRedirect("employees_management.jsp");
//                //session.setAttribute("user", username);
//                //response.sendRedirect("login.jsp");
//            
//        	}
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        response.sendRedirect("employees_management.jsp");
    }
}