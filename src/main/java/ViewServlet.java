import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/welcome")
public class ViewServlet extends HttpServlet {
    List<User> users = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext allUsersContext= req.getServletContext();
        allUsersContext.setAttribute("allUsers",users);

        ServletContext loogedUserContext= req.getServletContext();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean flag = (req.getParameter("rememberme")!=null?true:false);
        HttpSession userSession= req.getSession();

        loogedUserContext.setAttribute("loggedUserContext",loogedUserContext);


        HttpSession session = req.getSession();
        boolean found = checkAccount(username, password);
            if(found) {


                RequestDispatcher dispatcher = req.getRequestDispatcher("views/welcome.jsp");
                dispatcher.forward(req, resp);

                //resp.sendRedirect("/views/welcome.jsp");

            }else{
                resp.sendRedirect("/");


            }



//        session.setAttribute("user",userDto);
//
//        //set Cookies
//        if(req.getParameter("rememberme")!=null){
//            Cookie c = new Cookie("Name",username);
//            c.setMaxAge(30*24*60*60);
//            resp.addCookie(c);
//        }
//        else{
//            Cookie c = new Cookie("Name",username);
//            c.setMaxAge(0);
//            resp.addCookie(c);
//        }

    }

    public void sessionSetter(HttpSession session,List<User> usersSaved,User user) {
        //List<User> usersSaved = ; User user = ;
        if(session.isNew()){

            if(!(usersSaved.contains(user))){
                usersSaved.add(user);
                session.setAttribute("savedUser",usersSaved);
            }

        }else {
            usersSaved = (List<User>) session.getAttribute("savedUser");
            usersSaved.add(user);
            session.setAttribute("savedUser", usersSaved);
        }
    }

    //private void methodRendered(HttpServletResponse resp, String username) throws IOException {
//        PrintWriter out = resp.getWriter();
//        out.print("<html><head><title>ViewPage</title></head>");
//        out.print("<body><p>welcome " + username);
//        out.print("</p>");
//        out.print("<form action='/' method='GET'>");
//        out.print("<input type='submit' value='log-out' />");
//        out.print("</form></body></html>");

   // }
//   private void methodRendered(HttpServletResponse resp)throws ServletException, IOException{
//        resp.sendRedirect("views/welcome.jsp");
//   }
    public boolean checkAccount(String username, String password) {
        boolean found=false;

        for(User user:users){
            if(user.getUsername().equalsIgnoreCase(username)&&user.getPassword().equals(password))found=true;
        }
        return found;
    }

    @Override
    public void init() throws ServletException {

        users.addAll(new UserRepository().getUsers());


        super.init();
    }
}
