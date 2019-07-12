package cn._92ac.service;

import cn._92ac.bean.AddBookInfo;
import cn._92ac.bean.BorrowInfo;
import cn._92ac.mapper.BookMapper;
import cn._92ac.pojo.Book;
import cn._92ac.pojo.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
	
		@Autowired
		public BookMapper bookMapper;
	
		public List<Book> selectAllBook(){
			     List<Book> list = bookMapper.selectAll();
			     if(list!=null&&list.size()>0) {
			    	 return list;
			     }else {
			    	 return null;
			     }
		}
		public List<Borrow> selectAllBorrow() {
			List<Borrow> list = bookMapper.selectAllBorrow();
			if(list!=null&&list.size()>0) {
				return list;
			}else {
				return null;
			}
		}

		public boolean borrowBook(Borrow info) {
			return bookMapper.addBorrow(info);
		}

		public boolean addBook(AddBookInfo book) {
			return bookMapper.addBook(book);
		}
		public List<Book> getAllBookName() {
			return bookMapper.selectAllBookName();
		}

	
	
}
