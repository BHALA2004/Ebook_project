package com.admin.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.BookDAOimpl;
import com.DB.DBConnect;
import com.entity.BookDtls;
@WebServlet("/add_books")
@MultipartConfig
public class Books_add extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String bookname=req.getParameter("bname");
			String author=req.getParameter("author");
			String price = req.getParameter("price");
			String Category = req.getParameter("categories");
			String Status = req.getParameter("status");
			Part part = req.getPart("bimg");
			String filename = part.getSubmittedFileName();
			
			BookDtls b = new BookDtls(bookname,author,price,Category,Status,filename,"admin");
			//System.out.println(b);
			
			BookDAOimpl dao = new BookDAOimpl(DBConnect.getConn());
			
			
			
			
			
			boolean f = dao.addBooks(b);
			HttpSession session = req.getSession();
			if(f) {
				
				String Path = getServletContext().getRealPath("")+"book_img";
				//System.out.println(Path);
				
				File file = new File(Path);
				part.write(Path+File.separator+filename);
				
				
				session.setAttribute("Msg", "Book Added Successfully");
				resp.sendRedirect("admin/add_books.jsp");
			}
			else {
				session.setAttribute("fails", "Something wrong on server");
				resp.sendRedirect("\"admin/add_books.jsp\"");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
