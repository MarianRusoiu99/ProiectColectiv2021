package teamsManagement;

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

 
 
 
@WebServlet("/addTeam")
public class AddTeamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AddTeamDao addTeamDao;
 
    public void init() {
        addTeamDao = new AddTeamDao();
    }
 
    public AddTeamServlet() {
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
 
    	List<String> skills = new ArrayList<String>();
    	List<String> membrii = new ArrayList<String>();
    	
    	
        String numeEchipa = request.getParameter("numeEchipa");
        String liderEchipa = request.getParameter("liderEchipa");
        //String membruEchipa = request.getParameter("membru1Echipa");
        //String skillEchipa = request.getParameter("skill1Echipa");
        skills.add(request.getParameter("skill1Echipa"));
        skills.add(request.getParameter("skill2Echipa"));
        skills.add(request.getParameter("skill3Echipa"));
        skills.add(request.getParameter("skill4Echipa"));
        skills.add(request.getParameter("skill5Echipa"));
        
        membrii.add(request.getParameter("membru1Echipa"));
        membrii.add(request.getParameter("membru2Echipa"));
        membrii.add(request.getParameter("membru3Echipa"));
        membrii.add(request.getParameter("membru4Echipa"));
        membrii.add(request.getParameter("membru5Echipa"));
 
        AddTeamBean team = new AddTeamBean();
        
        team.setNumeEchipa(numeEchipa);
        team.setLiderEchipa(liderEchipa);
        team.setMembrii(membrii);
        team.setSkills(skills);
        
        
        try {
            
        	addTeamDao.addTeam(team);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        response.sendRedirect("teams_management.jsp");
    }
}
