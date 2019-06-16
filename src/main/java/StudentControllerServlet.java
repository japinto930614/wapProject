import models.Type;
import models.User;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/student")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDbUtil studentDbUtil=new StudentDbUtil();
	private List<User>users=new ArrayList<>();
	

	
	@Override
	public void init() throws ServletException {
		super.init();

	}

	private void allStudents(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		ServletContext allUsersContext= req.getServletContext();
		if(allUsersContext==null){
			resp.sendRedirect("/");
		}
		users=(List<User>) allUsersContext.getAttribute("allUsers");
		studentDbUtil=new StudentDbUtil();
		studentDbUtil.setUsers(users);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		allStudents(request,response);
		if(users.size()==0){
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listStudents(request, response);
				break;
				
			case "ADD":
				addStudent(request, response);
				break;
				
			case "LOAD":
				loadStudent(request, response);
				break;
				
			case "UPDATE":
				updateStudent(request, response);
				break;
			
			case "DELETE":
				deleteStudent(request, response);
				break;
				
			default:
				listStudents(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student id from form data
		String theStudentId = request.getParameter("studentId");
		
		// delete student from database
		studentDbUtil.deleteStudent(theStudentId);
		
		// send them back to "list students" page
		listStudents(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student info from form data
		int id = Integer.parseInt(request.getParameter("studentId"));

		String password = request.getParameter("password");
		
		// create a new student object

		
		// perform update on database
		studentDbUtil.updateStudent(""+id,password);
		
		// send them back to the "list students" page
		listStudents(request, response);
		
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read student id from form data
		String theStudentId = request.getParameter("studentId");
		
		// get student from database (db util)
		//Student theStudent = studentDbUtil.getStudent(theStudentId);
		
		// place student in the request attribute
		//request.setAttribute("THE_STUDENT", theStudent);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type=request.getParameter("type");
		Type t=Type.valueOf(type);
		String id=""+users.size()+1;
		//String email = request.getParameter("email");
		
		// create a new student object
		User theStudent = new User(id, username, password,t);
		

		listStudents(request, response);
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
//		ServletContext allUsersContext=request.getServletContext();
//		users=(List<User>)allUsersContext.getAttribute("allUsers");
		// get students from db util
		List<User> students = studentDbUtil.getStudents();
		
		// add students to the request
		request.setAttribute("STUDENT_LIST", students);
		HttpSession session= (HttpSession) request.getSession();
				session.setAttribute("AllStudents",students);
				
		// send to JSP page (view)
	RequestDispatcher dispatcher = request.getRequestDispatcher("views/list-students.jsp");
	dispatcher.forward(request, response);

	}


}













