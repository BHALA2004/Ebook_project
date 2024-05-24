package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookOrderimpl;
import com.DAO.CartDAOimpl;
import com.DB.DBConnect;
import com.entity.Book_Order;
import com.entity.Cart;

@WebServlet("/order")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			int id = Integer.parseInt(req.getParameter("id"));
			String name  = req.getParameter("username");
			String email  = req.getParameter("email");
			String phno  = req.getParameter("phno");
			String address  = req.getParameter("address");
			String landmark  = req.getParameter("landmark");
			String city  = req.getParameter("city");
			String state  = req.getParameter("state");
			String pincode  = req.getParameter("pincode");
			String paymenttype  = req.getParameter("payment");
			
			String fulladd = address+","+landmark+","+city+","+state+","+pincode;
			//System.out.println(name+" "+email+" "+" "+phno+" "+fulladd+" "+paymenttype);
			
			CartDAOimpl dao = new CartDAOimpl(DBConnect.getConn());
			List<Cart> blist=dao.getBookByUser(id);
			
			BookOrderimpl dao2 = new BookOrderimpl(DBConnect.getConn());
			
			Book_Order o = null;
			
			ArrayList<Book_Order> orderlist= new ArrayList<Book_Order>();
			Random  r = new Random();
			for(Cart c : blist) {
				o=new Book_Order();
				
				o.setOrderId("BOOK-ORD-00"+r.nextInt(1000));
				o.setUsername(name);
				o.setEmail(email);
				o.setPhno(phno);
				o.setFulladd(fulladd);
				o.setBookNmae(c.getBookName());
				o.setAuthor(c.getAuthor());
				o.setPrice(c.getPrice()+"");
				o.setPaymentType(paymenttype);
				orderlist.add(o);
				
				
				
			}
			
			if("noselect".equals(paymenttype)) {
				session.setAttribute("Fails", "choose your Payment Method");
				resp.sendRedirect("checkout.jsp");
				
			}
			else {
				
				boolean f = dao2.saveOrder(orderlist);
				if(f) {
					resp.sendRedirect("order_success.jsp");
					System.out.print("Order sucess");
				}
				else {
					session.setAttribute("Fails", "Your Order Failed");
					resp.sendRedirect("checkout.jsp");
				}
				
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
