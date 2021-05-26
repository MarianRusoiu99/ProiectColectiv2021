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
import javax.swing.JOptionPane;

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
         
        doPost(request,response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 
    	System.out.println("sunt in /echipa");
    	
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
        
        request.setAttribute("echipa", echipa);
        
        request.setAttribute("numeEchipa",echipa.get(0).getNumeEchipa());
        request.setAttribute("id_team",echipa.get(0).getId_team());
        
//        request.setAttribute("numeLider",echipa.getNumeLider());
//        request.setAttribute("prenumeLider",echipa.getPrenumeLider());
//        request.setAttribute("jobLider",echipa.getJobLider());
//        request.setAttribute("emailLider",echipa.getEmailLider());
//        request.setAttribute("telefonLider",echipa.getTelefonLider());
//        request.setAttribute("pozitieLider",echipa.getPozitieLider());

        request.getRequestDispatcher("echipa.jsp").forward(request, response);
        
        //response.sendRedirect("profile.jsp");
    	
    	
    	
    	
    	
//        try {
//            
//        	echipaDao.viewTeam();
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
// 
        //response.sendRedirect("employees_management.jsp");
    }
}