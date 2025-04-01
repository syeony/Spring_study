package com.ssafy.guestbook.controller;

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

@Controller
public class GuestBookController {
	
	private static final Logger log = LoggerFactory.getLogger(GuestBookController.class);

	@Autowired
	GuestBookService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	/** 전체 목록조회
	 */
	@GetMapping({"/listArticle"})
	public String listArticle(Model model) {
		log.debug("listArticle : ");
		
        List<GuestBookDto> list = service.listArticle();
        model.addAttribute("articles", list);
        return "guestbook/list";
	}

	/** 단건조회
	 */
	@GetMapping("/getArticle/{articleno}")
	public String getArticle(@PathVariable int articleno, Model model) {
		log.debug("getArticle : {}", articleno);		
		
        GuestBookDto dto = service.getArticle(articleno);
        model.addAttribute("dto", dto);
		log.debug("dto : {}", dto);		

		return "guestbook/detail";
	}

	// get방식으로 write로 호출하면 write.jsp가 열리도록 한다. 
    @GetMapping("/write")
    public String write() {
        return "guestbook/write";
    }
    
	/** 글쓰기
	 */
	@PostMapping("/writeArticle")
	public String writeArticle(GuestBookDto guestBookDto, Model model) {
		log.debug("writeArticle : {}", guestBookDto);		
        int result = service.writeArticle(guestBookDto);
        if(result > 0) {
        	log.debug("write success");
        }
		return "redirect:/listArticle";
	}

	// get방식으로 update로 호출하면 update.jsp가 열리도록 한다. 
	// update.jsp에서는 id로 dto를 조회해서 화면에 set 해 줘야 한다. 
    @GetMapping("/update/{articleno}")
    public String update(@PathVariable int articleno, Model model) {
		log.debug("update : {}", articleno);		

		GuestBookDto dto = service.getArticle(articleno);
        model.addAttribute("dto", dto);
		log.debug("dto : {}", dto);		

        return "guestbook/update";
    }

	/** 글 수정
	 */
	@PostMapping("/updateArticle")
	public String updateArticle(GuestBookDto guestBookDto, Model model) {
		log.debug("updateArticle : {}", guestBookDto);		
		
		int result = service.updateArticle(guestBookDto);
        if(result > 0) {
        	log.debug("update success");
        }
        
		return "redirect:/listArticle";
	}

	/** 글 삭제
	 */
	@GetMapping("/deleteArticle/{articleno}")
	public String deleteArticle(@PathVariable int articleno, Model model) {
		log.debug("deleteArticle : {}", articleno);		
		
		int result = service.deleteArticle(articleno);
        if(result > 0) {
        	log.debug("delete success");
        }
		return "redirect:/listArticle";
	}

}
