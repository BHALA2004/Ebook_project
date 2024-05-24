<%@page import="com.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.DAO.BookDAOimpl" %>
    <%@ page import="com.entity.BookDtls" %>
    <%@ page import="com.DB.DBConnect" %>
    <%@ page import="java.util.*" %>
    
    <%@ page import="com.entity.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>com.Ebook</title>
<%@include file="allComponents/allCss.jsp"%>
<style type="text/css">
.back-img {
	background: url("img/boook pic2.jpg");
	height: 50vh;
	width: 100%;
	background-repeat: no-repeat;
	background-size: cover;
}

.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>
</head>
<body style="Background-color: #f7f7f7">
<%  User u =(User)session.getAttribute("userobj"); %>

	<%@include file="allComponents/Navbar.jsp"%>
	<div class="container-fluid back-img">
		<h2 class="text-center text-white">EBook Management System</h2>
	</div>



	<!-- Start Recent Book List -->
	<div class="container">
		<h3 class="text-center">Recent Book</h3>
		<div class="row">
		
		<%
		BookDAOimpl dao2 = new BookDAOimpl(DBConnect.getConn());
		List<BookDtls> list2 = dao2.getRecentBook();
		for(BookDtls b : list2){%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="book_img/<%=b.getPhotoname() %>"
							style="width: 150px; heigth: 200px" class="img-thumblin">
						<p><%= b.getBookname() %></p>
						<p><%= b.getAuthor() %></p>
						
						<%
						if(b.getBookcategory().equals("Old")){
						%>
						<p>Category:<%=b.getBookcategory() %></p>
						<div class="row">
							 <a href="view.jsp?bid=<%=b.getBookid() %>"
								class="btn btn-success btn-sm ml-5">View Details</a> <a href=""
								class="btn btn-danger btn-sm"><%=b.getPrice() %><i class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
						
							<%
						}else{%>
						
						<p>Category:<%=b.getBookcategory() %></p>
						<div class="row">
						
						<% if(u==null){ %>
						
						<a href="login.jsp" class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i> Add Cart</a>
						
						<%}else {%>
						<a href="cart?bid=<%=b.getBookid()%>&&uid=<%=u.getId() %>" class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i> Add Cart</a> 
						
						<%}%>
						
							 <a href="view.jsp?bid=<%=b.getBookid() %>"
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

		<div class="text-right mt-1">
			<a href="all_recent_book.jsp" class="text-primary">View All</a>
		</div>
	</div>
	<!-- End Recent Book List -->

	<hr>

	<!-- Start New Book List -->
	<div class="container">
		<h3 class="text-center">New Books</h3>
		<div class="row">
			
			
			<% 
			
			BookDAOimpl dao = new BookDAOimpl(DBConnect.getConn());
			List <BookDtls> list = dao.getNewBook();
			for(BookDtls b:list){%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center ">
						<img alt="" src="book_img/<%= b.getPhotoname() %>"
							style="width: 150px; heigth: 200px" class="img-thumblin">
						<p><%= b.getBookname() %></p>
						<p><%= b.getAuthor() %></p>
						<p>Catogories:<%= b.getBookcategory() %></p>
						
					
					
						<div class="row">
						
						<% if(u==null){ %>
						
						<a href="login.jsp" class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i> Add Cart</a>
						
						<%}else {%>
						<a href="cart?bid=<%=b.getBookid()%>&&uid=<%=u.getId() %>" class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i> Add Cart</a> 
						
						<%}%>
						
							<a href="view.jsp?bid=<%=b.getBookid() %>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm "><%=b.getPrice() %><i class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
					</div>
				</div>
				</div>
			<%}
			
			%>
			


		</div>

		<div class="text-right mt-1">
			<a href="all_new_book.jsp" class="text-primary">View All</a>
		</div>
	</div>
	<!-- End New Book List -->

	<hr>

	<!-- Start old Book List -->
	<div class="container">
		<h3 class="text-center">Old Book</h3>
		<div class="row">
		
		<%
		BookDAOimpl dao3 = new BookDAOimpl(DBConnect.getConn());
		List<BookDtls> list3 = dao3.getOldBook();
		for(BookDtls b : list3){
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="book_img/<%=b.getPhotoname() %>"
							style="width: 150px; heigth: 200px" class="img-thumblin">
						<p><%= b.getBookname() %></p>
						<p><%= b.getAuthor() %></p>
						
						<p><%=b.getBookcategory() %></p>
						<div class="row">
							 <a href="view.jsp?bid=<%=b.getBookid() %>"
								class="btn btn-success btn-sm ml-5">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=b.getPrice() %><i class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
						
				
						  
					</div>
				</div>
			</div>
		<%}
		%>
		



		</div>

		<div class="text-right mt-1">
			<a href="all_old_book.jsp" class="text-primary">View All</a>
		</div>
	</div>
	<!-- End old Book List -->

	<%@include file="allComponents/footer.jsp"%>

</body>
</html>