package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@GetMapping("/write.do")
	public String write() {
		return "write";
	}

	@PostMapping("/write.do")
	public String save(Nvo nvo) {
		service.save(nvo);
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

}
