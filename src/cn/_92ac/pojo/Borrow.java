package cn._92ac.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Borrow {
	private int id;

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	private Book book;
	private int book_id;
	private int user_id;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date borrow_date;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date due_date;

	public Date getBorrow_date() {
		return borrow_date;
	}

	public void setBorrow_date(Date borrow_date) {
		this.borrow_date = borrow_date;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
