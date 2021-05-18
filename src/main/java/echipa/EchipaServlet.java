package echipa;

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

 
 
@WebServlet("/echipa")
public class EchipaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EchipaDao echipaDao;
 
    public void init() {
        echipaDao = new EchipaDao();
    }
 
    public EchipaServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/echipa.jsp");
        //????
        dispatcher.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 
    	
    	
    	HttpSession session = request.getSession();
        session.setAttribute("id1", LoginServlet.userID); //ce dracu esti tu ???
        request.setAttribute("id2", LoginServlet.userID);
        
        List<EchipaBean> echipa = new ArrayList<EchipaBean>();
        try {
			echipa = EchipaDao.viewTeam();
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
        
        request.setAttribute("numeMembru1", echipa.get(0).getNumeMembru());
        System.out.println("NUME MEMBRU: " + echipa.get(0).getNumeMembru());
        request.setAttribute("prenumeMembru1",echipa.get(0).getPrenumeMembru());
        System.out.println("PRENUME MEMBRU: " + echipa.get(0).getNumeMembru());
        request.setAttribute("jobMembru1",echipa.get(0).getJobMembru());
        request.setAttribute("emailMembru1",echipa.get(0).getEmailMembru());
        request.setAttribute("telefonMembru1",echipa.get(0).getTelefonMembru());
        request.setAttribute("pozitieMembru1",echipa.get(0).getPozitieMembru());
        
        
        request.setAttribute("numeMembru2", echipa.get(1).getNumeMembru());
        request.setAttribute("prenumeMembru2",echipa.get(1).getPrenumeMembru());
        request.setAttribute("jobMembru2",echipa.get(1).getJobMembru());
        request.setAttribute("emailMembru2",echipa.get(1).getEmailMembru());
        request.setAttribute("telefonMembru2",echipa.get(1).getTelefonMembru());
        request.setAttribute("pozitieMembru2",echipa.get(1).getPozitieMembru());
        
        request.setAttribute("numeEchipa",echipa.get(0).getNumeEchipa());
        
//        request.setAttribute("numeLider",echipa.getNumeLider());
//        request.setAttribute("prenumeLider",echipa.getPrenumeLider());
//        request.setAttribute("jobLider",echipa.getJobLider());
//        request.setAttribute("emailLider",echipa.getEmailLider());
//        request.setAttribute("telefonLider",echipa.getTelefonLider());
//        request.setAttribute("pozitieLider",echipa.getPozitieLider());
        
        request.getRequestDispatcher("echipa.jsp").forward(request, response);
        //response.sendRedirect("profile.jsp");
    	
    	
    	
    	
    	
        try {
            
        	echipaDao.viewTeam();

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