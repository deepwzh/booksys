package cn._92ac.controller;

import cn._92ac.bean.BorrowInfo;
import cn._92ac.bean.Result;
import cn._92ac.pojo.Book;
import cn._92ac.pojo.Borrow;
import cn._92ac.pojo.User;
import cn._92ac.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class BookController {
	
	@Autowired
	public BookService bookService;
	
	@ResponseBody
	@RequestMapping(value="/api/book", produces = "application/json;charset=utf-8")
	public List<Book> getAllBooks() {
		List<Book> cList=bookService.selectAllBook();
		System.out.println(cList);
		System.out.println("Hello World");
		return cList;
	}

	@ResponseBody
	@RequestMapping(value="/api/borrow", produces = "application/json;charset=utf-8")
	public List<Borrow> getAllBorrow() {
		List<Borrow> cList=bookService.selectAllBorrow();
		System.out.println(cList);
		System.out.println("Hello World");
		return cList;
	}
	@ResponseBody
	@RequestMapping(value="/api/addborrow", method= RequestMethod.POST)
	public Result borrowBook(@RequestBody Borrow borrow_info) {
		boolean res = bookService.borrowBook(borrow_info);
		if (res) {
			return new Result(0, "创建成功");
		} else {
			return new Result(1, "创建失败");
		}
	}

	@ResponseBody
	@RequestMapping(value="/api/booklist", method= RequestMethod.GET)
	public List<Book> borrowBook() {
		return bookService.getAllBookName();
	}
}
