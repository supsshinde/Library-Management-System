package org.techhub.Repository;

import java.util.List;

import org.techhub.Model.BookModel;

public interface BookRepository {
	
	public boolean isAddNewBooks(BookModel Model1);

	public List<BookModel> getBookListByCategoryId(int cid);
	
	public List<BookModel> getAllBooks();
	public boolean updateBookByName(String OldBook, String Ubook, String type, int Edition, int price, String author);
	public boolean searchBookByName(String SearchBook);
	public boolean deleteBookByName(String deleteBook);
	
	public boolean deleteBooksByNames(List<String> bookNames);

}
