package com.ssafy.ws.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.guestbook.dto.GuestBookDto;
import com.ssafy.guestbook.service.GuestBookService;
import com.ssafy.ws.controller.BookController;
import com.ssafy.ws.dto.Book;
import com.ssafy.ws.model.service.BookService;

@Controller
public class BookController {
	
	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	BookService service;
	
	@GetMapping("/") 
	public String index() {
		return "index";
	}
	
	/** 전체 목록조회
	 */
	@GetMapping({"/list","/listArticle"})
	public String listArticle(Model model) {
		log.debug("listArticle : ");
		
        List<Book> list = null;
		try {
			list = service.listArticle();
		} catch (Exception e) {
			e.printStackTrace();
		}
        model.addAttribute("articles", list);
        return "list";
	}
	
	/** 단건조회
	 */
	@GetMapping("/getArticle/{isbn}")
	public String getArticle(@PathVariable String isbn, Model model) {
		log.debug("getArticle : {}", isbn);		
		
        Book dto = null;
		try {
			dto = service.getArticle(isbn);
		} catch (Exception e) {
			e.printStackTrace();
		}
        model.addAttribute("dto", dto);
		log.debug("dto : {}", dto);		

		return "detail";
	}
	
	// get방식으로 write로 호출하면 write.jsp가 열리도록 한다. 
    @GetMapping("/register")
    public String write() {
        return "register";
    }
    
	/** 글쓰기
	 */
	@PostMapping("/writeArticle")
	public String writeArticle(Book Book, Model model) {
		log.debug("writeArticle : {}", Book);		
        int result = 0;
		try {
			result = service.writeArticle(Book);
		} catch (Exception e) {
			e.printStackTrace();
		}
        if(result > 0) {
        	log.debug("write success");
        }
		return "redirect:/listArticle";
	}

	// get방식으로 update로 호출하면 update.jsp가 열리도록 한다. 
	// update.jsp에서는 id로 dto를 조회해서 화면에 set 해 줘야 한다. 
    @GetMapping("/update/{isbn}")
    public String update(@PathVariable String isbn, Model model) {
		log.debug("update : {}", isbn);		

		Book dto = null;
		try {
			dto = service.getArticle(isbn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        model.addAttribute("dto", dto);
		log.debug("dto : {}", dto);		

        return "update";
    }

	/** 글 수정
	 */
	@PostMapping("/updateArticle")
	public String updateArticle(Book Book, Model model) {
		log.debug("updateArticle : {}", Book);		
		
		int result = 0;
		try {
			result = service.updateArticle(Book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(result > 0) {
        	log.debug("update success");
        }
        
		return "redirect:/listArticle";
	}

	/** 글 삭제
	 */
	@GetMapping("/deleteArticle/{isbn}")
	public String deleteArticle(@PathVariable String isbn, Model model) {
		log.debug("deleteArticle : {}", isbn);		
		
		int result = 0;
		try {
			result = service.deleteArticle(isbn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(result > 0) {
        	log.debug("delete success");
        }
		return "redirect:/listArticle";
	}
	
	
//	
//	@GetMapping("/") 
//	public String index() {
//		return "index";
//	}
//	
//	@GetMapping("/register")
//	public String register() {
//		return "register";
//	}
//	
//	@GetMapping("/list")
//	public String list() {
//		return "list"; 
//	}
//	
//	@GetMapping("/insert")
//	public String insert() {
//		return "redirect:/list"; 
//	}
//	
//	@GetMapping("/detail")
//	public String detail() {
//		return "detail"; 
//	}
//	
//	@GetMapping("/update")
//	public String update() {
//		return "update"; 
//	}
//	
//	@GetMapping("/delete")
//	public String delete() {
//		return "redirect:/list"; 
//	}
//	
//	@GetMapping("/updateSave")
//	public String updateSave() {
//		return "redirect:/list"; 
//	}
	
}
