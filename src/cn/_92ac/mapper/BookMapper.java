package cn._92ac.mapper;

import cn._92ac.bean.BorrowInfo;
import cn._92ac.pojo.Book;
import cn._92ac.pojo.Borrow;

import java.util.List;

public interface BookMapper {
		
	public List<Book> selectAll();
	public List<Borrow> selectAllBorrow();
	public boolean addBorrow(Borrow info);
	public List<Book> selectAllBookName();
	
	
}
