import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by vijayn on 7/29/2017.
 */
@WebFilter(filterName = "MyFilter")
public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        /*HttpSession session = ((HttpServletRequest)request).getSession(false);// don't create if it doesn't exist
        System.out.println(session);
        String url = ((HttpServletRequest) request).getRequestURL().toString();
        if(session==null){
            if(url.equals("http://localhost:8080/login.html")){
                chain.doFilter(request,response);
                return;
            }
            else {
                ((HttpServletResponse)response).sendRedirect("/login.html");
            }
        }
        else {
            chain.doFilter(request,response);
        }*/
        chain.doFilter(request,response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
