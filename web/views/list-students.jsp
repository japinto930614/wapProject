<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<title>List of Students</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2> University Student</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<input type="button" value="Add Student" 
				   onclick="window.location.href='add-student-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>ID</th>
					<th>Username</th>
					<th>Password</th>

				</tr>
				
				<c:forEach var="tempStudent" items="${STUDENT_LIST}">

					<!-- set up a link for each student -->
					<c:url var="tempLink" value="/student">
						<c:param name="command" value="LOAD" />
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="/student">
						<c:param name="command" value="DELETE" />
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>

					<tr>
						<td> ${tempStudent.id} </td>
						<td> ${tempStudent.username} </td>
						<td> ${tempStudent.password} </td>
						<td>
							<a href="${tempLink}">Update</a>
							 |
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
							Delete</a>
						</td>
					</tr>

				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








