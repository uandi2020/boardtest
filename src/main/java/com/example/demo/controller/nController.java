package com.example.demo.controller;


import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Nvo;
import com.example.demo.service.nService;

@Controller
public class nController {

	@Autowired
	nService service;

	@GetMapping
	public String main(Model model) {

		List<Nvo> list = service.getList();
		model.addAttribute("list",list);
		return "list";
	}

	@GetMapping("/list_test")
	public String Search(Model model,
			@RequestParam(value="keyWord") String keyWord,
		 HttpServletRequest request) {
		List<Nvo> boardlist = service.findByTitleContainingIgnoreCase(keyWord);
		
		
		System.out.println(boardlist +"zzzzzzzzzzzzz");
		System.out.println("keWord"+keyWord);
		model.addAttribute("list", boardlist);

//		List<Nvo> list = service.getList();
//		model.addAttribute("list",list);
		return "list";
	}

	@GetMapping("/write.do")
	public String write() {
		return "write";

	}

	@PostMapping("/write.do")
	public String save(@RequestParam("imgInfo") MultipartFile files, Nvo nvo) {
		try {


			service.save(nvo);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "write";
	}

	@RequestMapping("/delete/{idx}")
	public String delete(@PathVariable Long idx, Model model) {
		Nvo nvo = service.findByIdx(idx);
		model.addAttribute("list", nvo);
		return "redirect:/index";
	}

	@RequestMapping("/detail/{idx}")
	public String detail(@PathVariable Long idx, Model model) {
		Nvo nvo = service.getByIdx(idx);
		model.addAttribute("list", nvo);
		return "detail";
	}

	@RequestMapping("/update")
	public String update(Nvo nvo) {
		service.save(nvo);
		return "redirect:/";
	}

//	@GetMapping
//	public String search(@RequestParam(value="keyword") String keyword, Model model) {
//		List<Nvo> boardlist = service.findByTitleContainingIgnoreCase(keyword);
//		model.addAttribute("boardlist", boardlist);
//
//		return "redirect:/";
//	}

//	@GetMapping("/list")
//	public String list(Model model, @PageableDefault(size = 2) Pageable pageable) {
//		Page<Nvo> boards = service.findAll(pageable);
//		boards.getTotalElements();
//
//		int startPage = Math.max(0,  boards.getPageable().getPageNumber() -4);
//		int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() +4);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("boards", boards);
//		return "/list";
//	}




}
