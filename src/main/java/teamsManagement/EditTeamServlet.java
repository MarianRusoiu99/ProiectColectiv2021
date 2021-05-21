package teamsManagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
 
 
@WebServlet("/editTeam")
public class EditTeamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EditTeamDao editTeamDao;
 
    public void init() {
        editTeamDao = new EditTeamDao();
    }
 
    public EditTeamServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/teams_management.jsp");
        //????
        dispatcher.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 
    	
        String numeEchipa = request.getParameter("numeEchipa");
        String liderEchipa = request.getParameter("liderEchipa");
        String membruEchipa = request.getParameter("membru1Echipa");
        String skillEchipa = request.getParameter("skill1Echipa");
 
        AddTeamBean team = new AddTeamBean();
        
        team.setNumeEchipa(numeEchipa);
        team.setLiderEchipa(liderEchipa);
        team.setMembruEchipa(membruEchipa);
        team.setSkillEchipa(skillEchipa);
        
        
        try {
            
        	editTeamDao.editTeam(team);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        response.sendRedirect("teams_management.jsp");
    }
}
