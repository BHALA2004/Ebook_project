package com.user.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.lang.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookDAOimpl;
import com.DAO.CartDAOimpl;
import com.DB.DBConnect;
import com.entity.BookDtls;
import com.entity.Cart;


@WebServlet("/cart")
public class Cartsevlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int bid = Integer.parseInt(req.getParameter("bid"));
			int uid = Integer.parseInt(req.getParameter("uid"));
			BookDAOimpl dao = new BookDAOimpl(DBConnect.getConn());
			BookDtls b = dao.getBookById(bid);
			Cart c = new Cart();
			c.setBid(bid);
			c.setUserId(uid);
			c.setBookName(b.getBookname());
			c.setAuthor(b.getAuthor());
			c.setPrice(Double.parseDouble(b.getPrice()));
			c.setTotal_price(Double.parseDouble(b.getPrice()));
			CartDAOimpl dao2 = new CartDAOimpl(DBConnect.getConn());
			boolean f  = dao2.addCart(c);
			
			HttpSession  session = req.getSession();
			
			
			if(f) {
				session.setAttribute("addcart", "Book Added to Cart");
				resp.sendRedirect("all_new_book.jsp");
				
			}
			else {
				session.setAttribute("failed", "Something wrong on server");
				resp.sendRedirect("all_new_book.jsp");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
