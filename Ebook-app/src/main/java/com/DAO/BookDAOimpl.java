package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.BookDtls;

public class BookDAOimpl implements BookDAO{

	
	private Connection conn;
	
	
	public BookDAOimpl(Connection conn) {
		super();
		this.conn = conn;
	}


	@Override
	public boolean addBooks(BookDtls b) {
		boolean f = false;
		try {
			String sql="insert into book_details(book_name,author,price,book_category,status,photo,user_email) values (?,?,?,?,?,?,?) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBookname());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPrice());
			ps.setString(4, b.getBookcategory());
			ps.setString(5, b.getStatus());
			ps.setString(6, b.getPhotoname());
			ps.setString(7, b.getEmail());
			
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}


	@Override
	public List<BookDtls> getallbook() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls  b = null;
		try {
			String sql = "select * from book_details";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				b = new BookDtls();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public BookDtls getBookById(int id) {
		
		BookDtls b =null;
		try {
			String sql = "select * from book_details where bookid = ?";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				b = new BookDtls();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b; 
		
	}


	@Override
	public boolean updateEditBooks(BookDtls b) {
		boolean f = false;
		try {
			String sql = "update book_details set book_name=?,author=?,price=?,status=? where bookid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBookname());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPrice());
			ps.setString(4, b.getStatus());
			ps.setInt(5, b.getBookid());
			
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}


	public boolean DeleteBooks(int id) {
		boolean f = false;
		try {
			String sql = "delete from book_details where bookid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i==1) {
				f= true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}


	@Override
	public List<BookDtls> getNewBook() {
		List <BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b= null;
		try {
			String sql = "select * from book_details where book_category=? and status=? order by bookid DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "New");
			ps.setString(2, "Active");
			ResultSet rs = ps.executeQuery();
			int i=1;
			while(rs.next() && i<=4) {
				b=new BookDtls();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);i++;
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}


	
	public List<BookDtls> getRecentBook() {
		List <BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b= null;
		try {
			String sql = "select * from book_details where status=? order by bookid DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");

			ResultSet rs = ps.executeQuery();
			int i=1;
			while(rs.next() && i<=4) {
				b=new BookDtls();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);i++;
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}


	@Override
	public List<BookDtls> getOldBook() {
		
		List <BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b= null;
		try {
			String sql = "select * from book_details where book_category=? and status=? order by bookid DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Old");
			ps.setString(2, "Active");
			ResultSet rs = ps.executeQuery();
			int i=1;
			while(rs.next() && i<=4) {
				b=new BookDtls();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);i++;
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}


	@Override
	public List<BookDtls> getAllRecentBook() {
		List <BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b= null;
		try {
			String sql = "select * from book_details where status=? order by bookid DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");

			ResultSet rs = ps.executeQuery();
			
			while(rs.next() ) {
				b=new BookDtls();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}


	@Override
	public List<BookDtls> getAllNewBook() {
		List <BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b= null;
		try {
			String sql = "select * from book_details where book_category=? and status=? order by bookid DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "New");
			ps.setString(2, "Active");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				b=new BookDtls();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<BookDtls> getAllOldBook() {
		List <BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b= null;
		try {
			String sql = "select * from book_details where book_category=? and status=? order by bookid DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Old");
			ps.setString(2, "Active");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next() ) {
				b=new BookDtls();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	
	
	
	
	
	
	
	
		
}
