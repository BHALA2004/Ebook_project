package com.user.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOimpl;
import com.DB.DBConnect;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String name=req.getParameter("fname");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String pass = req.getParameter("password");
			String check = req.getParameter("check");
			//System.out.println(name+ " "+ email + " "+ phone + " "+pass+" "+check);
			User us = new User();
			us.setName(name);
			us.setEmail(email);
			us.setPhno(phone);
			us.setPassword(pass);
			HttpSession session = req.getSession();
			if(check!=null) {
				UserDAOimpl dao = new UserDAOimpl(DBConnect.getConn());
				boolean f = dao.userRegister(us);
				if(f) {
					session.setAttribute("Success", "Registration Successfully");
					resp.sendRedirect("register.jsp");
					//System.out.println("User Register Sucess!");
				}
				else {
					session.setAttribute("Fails", "404-Error");
					resp.sendRedirect("register.jsp");
					//System.out.println("404-Error");
				}
			}
			else {
				session.setAttribute("Fails", "Accept term & conditions");
				resp.sendRedirect("register.jsp");
				//System.out.println("Accept term & conditions");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
