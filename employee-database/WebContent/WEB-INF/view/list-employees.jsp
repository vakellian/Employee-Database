<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
	<title>Employee List</title>
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Employee Roster</h2>
		</div>
	</div>
	
	<div id="container">

		<div id="content">
		
			<input type="button" value="Add Employee" 
				    onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button" 		   	
			/>

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Job Title</th>
					<th>Salary</th>
					<th>Action</th>
				</tr>

				<!-- creates a loop to print out employees -->
				<c:forEach var="tempEmployee" items="${employees}">
				
					<!-- creates update link with employee id -->
					<c:url var="updateLink" value="/employee/showFormForUpdate">
						<c:param name="employeeId" value="${tempEmployee.id}" />
					</c:url>
					
					<!-- creates delete link with employee id -->
					<c:url var="deleteLink" value="/employee/delete">
						<c:param name="employeeId" value="${tempEmployee.id}" />
					</c:url>

					<tr>
						<td>${tempEmployee.firstName}</td>
						<td>${tempEmployee.lastName}</td>
						<td>${tempEmployee.email}</td>
						<td>${tempEmployee.jobTitle}</td>
						<td>${tempEmployee.salary}</td>
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this Employee?'))) return false">Delete</a>
							
						</td>
					</tr>

				</c:forEach>
			</table>

		</div>

	</div>
	
	
</body>

</html>