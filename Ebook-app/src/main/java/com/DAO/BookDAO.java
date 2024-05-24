package com.DAO;

import java.util.List;

import com.entity.BookDtls;

public interface BookDAO {
	
	
	public boolean addBooks(BookDtls b);
	
	public List<BookDtls> getallbook();

	
	public BookDtls getBookById(int id);
	
	public boolean updateEditBooks(BookDtls b);
	
	public boolean DeleteBooks(int id);
	
	public List<BookDtls> getNewBook();
	
	public List<BookDtls> getRecentBook();
	
	public List<BookDtls> getOldBook();
	
	public List<BookDtls> getAllRecentBook();
	
	public List<BookDtls> getAllNewBook();
	
	public List<BookDtls> getAllOldBook();
	
	
}
