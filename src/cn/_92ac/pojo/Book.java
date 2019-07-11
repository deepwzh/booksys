package cn._92ac.pojo;

import java.sql.Date;

public class Book {
		private Integer id;
		private String isbn;
		private String name;
		private Date date;
		private int num;
		private BookType type;

	public BookType getType() {
		return type;
	}

	public void setType(BookType type) {
		this.type = type;
	}

	public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public int getExist_num() {
			return exist_num;
		}
		public void setExist_num(int exist_num) {
			this.exist_num = exist_num;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}

	public BookPub getPub() {
		return pub;
	}

	public void setPub(BookPub pub) {
		this.pub = pub;
	}

	private BookPub pub;
		private int exist_num;
		private double price;


}
