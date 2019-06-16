import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter  implements Filter {
    @Override
    public void init(FilterConfig argo) throws ServletException {
        //users.addAll(new UserRepository().getUsers());
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
       HttpServletRequest request=(HttpServletRequest)req;
       HttpServletResponse response=(HttpServletResponse) resp;
        if (request.getParameterMap().containsKey("username")) {
            //String username = req.getParameter("username");
            filterChain.doFilter(req, resp);

        }
       else {

//                RequestDispatcher dispatcher = request.getRequestDispatcher("/");
//                dispatcher.forward(req, resp);
            ((HttpServletResponse) resp).sendRedirect("/");
       }
    }

    @Override
    public void destroy() {

    }
}





