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
	 * @throws Exception 
	 */
	@GetMapping({"/list","/listArticle"})
	public String listArticle(Model model) throws Exception {
		log.debug("listArticle : ");
		
        List<Book> list = null;
		list = service.listArticle();
        model.addAttribute("articles", list);
        return "list";
	}
	
	/** 단건조회
	 * @throws Exception 
	 */
	@GetMapping("/getArticle/{isbn}")
	public String getArticle(@PathVariable String isbn, Model model) throws Exception {
		log.debug("getArticle : {}", isbn);		
		
        Book dto = null;
		dto = service.getArticle(isbn);
        model.addAttribute("dto", dto);
		log.debug("dto : {}", dto);		

		return "detail";
	}
	
	@GetMapping("/bookInfoWithComment/{isbn}")
	public String bookInfoWithComment(@PathVariable String isbn, Model model) throws Exception {
		log.debug("bookInfoWithComment : {}", isbn);		
		
        Book dto = null;

		dto = service.getArticle(isbn);
		dto.setList(service.bookInfoWithComment(isbn));

        model.addAttribute("dto", dto);
		log.debug("dto : {}", dto);

		return "bookinfo";
	}
	
	// get방식으로 write로 호출하면 write.jsp가 열리도록 한다. 
    @GetMapping("/register")
    public String write() {
        return "register";
    }
    
	/** 글쓰기
	 * @throws Exception 
	 */
	@PostMapping("/writeArticle")
	public String writeArticle(Book Book, Model model) throws Exception {
		log.debug("writeArticle : {}", Book);		
        int result = 0;

		result = service.writeArticle(Book);

        if(result > 0) {
        	log.debug("write success");
        }
		return "redirect:/listArticle";
	}

	// get방식으로 update로 호출하면 update.jsp가 열리도록 한다. 
	// update.jsp에서는 id로 dto를 조회해서 화면에 set 해 줘야 한다. 
    @GetMapping("/update/{isbn}")
    public String update(@PathVariable String isbn, Model model) throws Exception {
		log.debug("update : {}", isbn);		

		Book dto = null;

		dto = service.getArticle(isbn);

        model.addAttribute("dto", dto);
		log.debug("dto : {}", dto);		

        return "update";
    }

	/** 글 수정
	 * @throws Exception 
	 */
	@PostMapping("/updateArticle")
	public String updateArticle(Book Book, Model model) throws Exception {
		log.debug("updateArticle : {}", Book);		
		
		int result = 0;
		result = service.updateArticle(Book);
        if(result > 0) {
        	log.debug("update success");
        }
        
		return "redirect:/listArticle";
	}

	/** 글 삭제
	 * @throws Exception 
	 */
	@GetMapping("/deleteArticle/{isbn}")
	public String deleteArticle(@PathVariable String isbn, Model model) throws Exception {
		log.debug("deleteArticle : {}", isbn);		
		
		int result = 0;

		result = service.deleteArticle(isbn);

        if(result > 0) {
        	log.debug("delete success");
        }
		return "redirect:/listArticle";
	}
	
	
}
