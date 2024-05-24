<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.DAO.BookDAOimpl" %>
    <%@ page import="com.entity.BookDtls" %>
    <%@ page import="com.DB.DBConnect" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recent Book</title>
<style type="text/css">


.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>
<%@include file="allComponents/allCss.jsp"%>
</head>
<body>
<%@include file="allComponents/Navbar.jsp"%>
<div class="container-fluid">
<div class="row p-3">

<%
		BookDAOimpl dao2 = new BookDAOimpl(DBConnect.getConn());
		List<BookDtls> list2 = dao2.getAllRecentBook();
		for(BookDtls b : list2){%>
			<div class="col-md-3">
				<div class="card crd-ho mt-2">
					<div class="card-body text-center">
						<img alt="" src="book_img/<%=b.getPhotoname() %>"
							style="width: 100px; heigth: 150px" class="img-thumblin">
						<p><%= b.getBookname() %></p>
						<p><%= b.getAuthor() %></p>
						
						<%
						if(b.getBookcategory().equals("Old")){
						%>
						<p>Category:<%=b.getBookcategory() %></p>
						<div class="row">
							 <a href=""
								class="btn btn-success btn-sm ml-5">View Details</a> <a href=""
								class="btn btn-danger btn-sm"><%=b.getPrice() %><i class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
						
							<%
						}else{%>
						
						<p>Category:<%=b.getBookcategory() %></p>
						<div class="row">
							<a href="" class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i> Add Cart</a> <a href=""
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm"><%=b.getPrice() %><i class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
						
						<%}%>
						
						
				
						
					</div>
				</div>
			</div>
		<%}
		%>
		

</div>
</div>
</body>
</html>