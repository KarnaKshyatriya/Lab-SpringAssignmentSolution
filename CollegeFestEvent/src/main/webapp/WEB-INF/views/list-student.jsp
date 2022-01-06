<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
    integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>College Fest</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center pt-5" style="color: #000080;">Student
			Registration List </h1>
		<hr>
		<br> <br>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Department</th>
					<th scope="col">Country</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Student}" var="student">
					<tr>
						<td><c:out value="${student.name}" /></td>
						<td><c:out value="${student.department}" /></td>
						<td><c:out value="${student.country}" /></td>
						<td>
							<!-- Add "update" button/link --> 
							<a href="/CollegeFestEvent/student/update?studentId=${student.id}"	class="btn btn-primary btn-md mr-3">Update</a>
							<!-- Add "delete" button/link -->
							<a href="/CollegeFestEvent/student/delete?studentId=${student.id}" class="btn btn-danger btn-md"
							onclick="if (!(confirm('Are you sure you want to delete this entry?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
		<!-- Add a button -->

		<a style="background-color: #ff3e6c;border:none;font-weight:500;" href="/CollegeFestEvent/student/add"	class="btn btn-primary mr-3">Add Student  </a>

        <a style="background-color: #ff3e6c;border:none;font-weight:500" href="/CollegeFestEvent/logout" class="btn btn-primary ml-3">Logout</a>


	</div>
</body>
</html>