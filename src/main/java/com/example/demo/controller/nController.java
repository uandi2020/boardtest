package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Nvo;
import com.example.demo.service.nService;

@Controller
public class nController {
	
	@Autowired
	nService service;
	
	@GetMapping
	public String home(Model model) {
		List<Nvo> list = service.getList();
		if(list != null)
		model.addAttribute("aaa",list);
		return "index";
	}
	
	@GetMapping("/write.do")
	public String write() {
		return "/write";
	}
	
	@PostMapping("/write.do")
	public String save(Nvo nvo) {
		service.save(nvo);
		return "redirect:/";
	}
	
	@GetMapping("detail/{idx}")
	public String detail(@PathVariable Long idx, Model model) {
		Nvo nvo = service.getByIdx(idx);
		model.addAttribute("list",nvo);
		return "detail";
	}
	
	@GetMapping("update/{idx}")
	public String update(@PathVariable Long idx, Model model) {
		Nvo nvo = service.findByIdx(idx);
		model.addAttribute("list", nvo);
		return "update";
	}  //단순한 페이지 이동겸 idx 가지고와서 보여줘라고 요청
	
	
	@PostMapping("/update")
	public String update1(Nvo nvo) {
		service.update(nvo);
		return "redirect:/";
	}
	
	//진짜 업데이트하는 데이터 처리
	
	@GetMapping("delete/{idx}") //뿌려줄거 아니면 모델 쓸필요 없음..!
	public String delete(@PathVariable long idx) { //idx를 가져와서 지우기만 하면 되는거니까 (요청만할거니까) 그릇에 담을필요없다
		service.deleteByIdx(idx); //리턴할게 없으면 entity가 필요없다 
		return "redirect:/";
	}
}
