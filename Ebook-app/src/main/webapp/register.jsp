<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EBook-register</title>
<%@include file="allComponents/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="allComponents/Navbar.jsp"%>>
	<div class="container p-2">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<h4 class="text-center mt-2">Registration</h4>
					<div class="card-body">

						<c:if test="${not empty Success}">
							<p class="text-center text-success">${Success}</p>
							<c:remove var="Success" scope="session" />
						</c:if>

						<c:if test="${not empty Fails}">
							<p class="text-center text-danger">${Fails}</p>
							<c:remove var="Fails" scope="session" />
						</c:if>



						<form action="register" method="post">

							<div class="form-group">
								<label for="exampleInputEmail1">Enter Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="fname">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="email">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Phone Number</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="phone">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									required="required" name="password">
							</div>
							<div class="form-check">
								<input type="checkbox" class="form-check-input" name="check"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">Agree Terms & Condition</label>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
	<%@include file="allComponents/footer.jsp"%>
</body>
</html>