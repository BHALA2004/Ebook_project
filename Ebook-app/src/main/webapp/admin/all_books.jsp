<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.DAO.BookDAOimpl" %>
    <%@ page import="com.entity.BookDtls" %>
    <%@ page import="com.DB.DBConnect" %>
    <%@ page import="java.util.*" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:All Books</title>
<%@include file="allCss.jsp" %>
</head>
<body>
<%@include file="Navbar.jsp" %>

<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp"></c:redirect>

	</c:if>
	
<h3 class="text-center">Hello,Admin</h3>


	<c:if test="${not empty Msg  }">
		<h5 class="text-center text-success">${Msg }</h5>
		<c:remove var="Msg" scope="session" />
	</c:if>

	<c:if test="${not empty fails }">
		<h5 class="text-center text-danger">${fails }</h5>
		<c:remove var="fails" scope="session" />
	</c:if>


	<table class="table table-striped">
  <thead class="bg-primary text-white">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Image</th>
      <th scope="col">Book Name</th>
      <th scope="col">Author</th>
      <th scope="col">Price</th>
      <th scope="col">Categories</th>
      <th scope="col">Status</th>
      <th scope="col">Action</th>
      
    </tr>
  </thead>
  <tbody>
  
  <% BookDAOimpl dao = new BookDAOimpl(DBConnect.getConn());
     List<BookDtls> list = dao.getallbook();
     for(BookDtls b : list){%>

			<tr>
				<th scope="row"><%=b.getBookid() %></th>
				<td><img src="../book_img/<%=b.getPhotoname()%>" style="width:50px;height:50px;">  </td>
				<td><%=b.getBookname() %></td>
				<td><%=b.getAuthor() %></td>
				<td><%=b.getPrice() %></td>
				<td><%=b.getBookcategory()%></td>
				<td><%=b.getStatus()%></td>
				<td><a href="editbooks.jsp?id=<%= b.getBookid() %>" class="btn btn-sm btn-primary"><i class="fa-regular fa-pen-to-square"></i> Edit</a> <a
					href="../delete?id=<%=b.getBookid() %>" class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i> Delete</a></td>
			</tr>


			<%
			}
			%>
  
  
   
   
    
  </tbody>
</table>
<div style="margin-top:50%;">
	<%@include file="footer.jsp" %>
	</div>
	
</body>
</html>