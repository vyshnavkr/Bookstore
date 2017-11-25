<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Book Form</title>
	</head>
	<body>
		<center>
			<h1>Books Management</h1>
			<h2>
				<a href = "ControllerServlet?action=new">Add New Book</a> 
				<a href = "ControllerServlet?action=list">List All Book</a> 
			</h2>
		</center>
		<div align="center">
			<c:if test="${book!=null}">
				<form action="ControllerServlet?action=update" method="post">
			</c:if>
			<c:if test="${book==null}">
				<form action="ControllerServlet?action=insert" method="post">
			</c:if>
			<table border="1" cellpadding="5">
				<caption>
					<h2>
						<c:if test="${book!=null}"> Edit Book</c:if>
						<c:if test="${book==null}"> Add new Book</c:if>
					</h2>
				</caption>
				<c:if test="${book!=null}">
					<input type="hidden" name="id" value="<c:out value='${book.id}'/>"></input>
					
				</c:if>
				<tr>
					<th>Title:</th>
					<td>
						<input type="text" name="title" size="45" value="<c:out value='${book.title}'/>"></input>
					</td>
				</tr>
				<tr>
					<th>Author:</th>
					<td>
						<input type="text" name="author" size="45" value="<c:out value='${book.author}'/>"></input>
					</td>
				</tr>
				<tr>
					<th>Price:</th>
					<td>
						<input type="text" name="price" size="45" value="<c:out value='${book.price}'/>"></input>
					</td>
				</tr>
				<tr>
				<td colspan="2" align="center">
					<input type="submit" value="save"></input>
				</td>
				</tr>
			</table>
			</form>
		</div>
	</body>
</html>