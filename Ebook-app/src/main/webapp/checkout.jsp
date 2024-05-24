<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
	<%@ page import="com.DAO.CartDAOimpl"%>
<%@ page import="com.entity.BookDtls"%>
<%@ page import="com.entity.User"%>
<%@ page import="com.entity.Cart"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cart page</title>
<%@include file="allComponents/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="allComponents/Navbar.jsp"%>
	<c:if test="${empty userobj }">
	<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	
	<c:if test="${not empty Success }">
	<div class="alert alert-success" role="alert">${Success }
</div>
<c:remove var="Success" scope="session"/>
	</c:if>
	
	<c:if test="${not empty Fails }">
	<div class="alert alert-danger text-center" role="alert">${Fails }
</div>
<c:remove var="Fails" scope="session"/>
	</c:if>
	
	<div class="container">
		<div class="row p-2">
			<div class="col-md-6">

				<div class="card bg-white">
					<div class="card-body ">
						<h3 class="text-center text-success">Your Selected Item</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">Book Name</th>
									<th scope="col">Author</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
							<%
							User u=(User)session.getAttribute("userobj");
							
							CartDAOimpl dao = new CartDAOimpl(DBConnect.getConn());
							List<Cart> cart = dao.getBookByUser(u.getId());
							Double totalPrice=0.000;
							for(Cart c : cart){
								 totalPrice=c.getTotal_price();
							
							%>
								
								
								<tr>
									<th scope="row"><%=c.getBookName() %></th>
									<td><%=c.getAuthor() %></td>
									<td><%=c.getPrice() %></td>
									<td>
									<a href="remove_book?bid=<%=c.getBid()%>&&uid=<%=c.getUserId()%>" class="btn btn-sm btn-danger">Remove</a>
									</td>
								</tr>
								
							<%}
							%>
							
							<tr>
							<td>Total Price </td>
							<td></td>
							<td></td>
							<td><%=totalPrice %></td>
							
							</tr>
							
								
							</tbody>
						</table>

					</div>

				</div>
			</div>

			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Your Details for Order</h3>
						<form action="order" method="post">
						<input type="hidden" value="${userobj.id }" name="id">
						
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Name</label> <input type="text" name="username"
										class="form-control" id="inputEmail4" value="${userobj.name }">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Email</label> <input
										type="email" name="email" class="form-control" id="inputPassword4" value="${userobj.email }" 
										>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Phone Number</label> <input type="number" name="phno"
										class="form-control" id="inputEmail4" value="${userobj.phno }">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Address</label> <input
										type="text" name="address" class="form-control" id="inputPassword4"
										>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Landmark</label> <input type="text" name="landmark"
										class="form-control" id="inputEmail4" >
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">City</label> <input
										type="text" name="city" class="form-control" id="inputPassword4"
										>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">State</label> <input type="text" name="state"
										class="form-control" id="inputEmail4" >
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Pincode</label> <input
										type="number" name="pincode" class="form-control" id="inputPassword4"
										>
								</div>	</div>
								<div class="form-group">
								<label>Payment Mode</label><select class="form-control" name="payment">
								<option value="noselect">---Select---</option>
								<option value="COD">Cash On delivery</option>
								</select>
								</div>
								<div class="text-center">
								<button class="btn btn-warning">Order Now</button>
								<a href="index.jsp" class="btn btn-success">Continue Shopping</a>
								</div>
								
						


						</form>
					</div>
				</div>
			</div>


		</div>
	</div>
	
	<%@include file="allComponents/footer.jsp"%>
</body>
</html>