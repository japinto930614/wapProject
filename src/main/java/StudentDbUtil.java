import models.Type;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class StudentDbUtil {

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	private List<User> users;


	
	public List<User> getStudents() throws Exception {
		
		List<User> students = new ArrayList<>();
		for(User user:users){
			if(((user.getType().equals(Type.Student)))) {
				students.add(user);
			}
		}
		return students;
	}


	public void addStudent(User theStudent) throws Exception {
		if(!(users.contains(theStudent)))
		users.add(theStudent);
	}

	public User getStudent(String theStudentId)  {

		for(User student:users){
			if(theStudentId.equals(student.getUsername()))return student;
		}

		return null;
	}

	public void updateStudent(String id,String password)  {

		for(User student:users){
			if(id.equals(student.getId())){
				student.setPassword(password);
			}
		}

	}

	public void deleteStudent(String theStudentId)  {

		for(User student:users){
			if(theStudentId.equals(student.getUsername())){
				int i=users.indexOf(student);
				users.remove(i);
			}
		}

	}
}















