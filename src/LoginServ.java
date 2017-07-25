import DaoImpl.AdminDaoImpl;
import DaoImpl.OperatorDaoImpl;
import Utilities.Constants;
import entities.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by vijayn on 7/23/2017.
 */
@WebServlet(name = "LoginServ")
public class LoginServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    met(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        met(request,response);
    }
    void met(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        AdminDaoImpl admin = new AdminDaoImpl();
        OperatorDaoImpl operator = new OperatorDaoImpl();
        String username=request.getParameter(Constants.ParaUname);
        String password = request.getParameter(Constants.ParaPass);
        if(admin.validate(new Admin(username, password))) {
           // return 1;
            HttpSession session=request.getSession();
            //session.setMaxInactiveInterval(Constants.max_inactive_level);
            session.setAttribute(Constants.isAdmin,Constants.val_true);
            session.setAttribute("uname",username);
            System.out.println(session.getAttribute("uname"));
            if(session==null){System.out.println("null session");}else {System.out.println(session);}
            System.out.println("admin detected");
            response.getWriter().print("admin detected");
            request.getRequestDispatcher("HomeServlet").forward(request,response);
        }
        else if(operator.validate(username, password)){
            //return 2;
            HttpSession session=request.getSession();
            //session.setMaxInactiveInterval(Constants.max_inactive_level);
            session.setAttribute(Constants.isAdmin,Constants.val_false);
            System.out.println(session.getAttribute("uname"));
            session.setAttribute("uname",username);
            System.out.print("operator detected");
            request.getRequestDispatcher("Home_Op.html").forward(request,response);
        }
        else {
            //return 0;
            response.getWriter().print("check in your credentials");
            request.getRequestDispatcher("login.html").forward(request,response);
        }
    }
}
