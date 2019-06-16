import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        System.out.println("before destroying:"+session.getAttribute("user").toString());
        if(session!=null){
            session.invalidate();
        }
        Cookie[] cookies = req.getCookies();
        String username = "", password = "", rememberVal = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                }
                if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        //resp.sendRedirect("index.jsp");
        resp.sendRedirect("/");
    }
}
