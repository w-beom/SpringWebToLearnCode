package com.study.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.domain.SampleDTO;
import com.study.domain.SampleDTOList;
import com.study.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@GetMapping("/ex01")
	public String basic(SampleDTO dto) {
		log.info("" + dto);
		System.out.println("adsadsadadasdadsdasdads");

		return "ex01";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);

		return "ex02";
	}

	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids : " + ids);

		return "ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("arrays ids : " + Arrays.toString(ids));

		return "ex02Array";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos : "+list);
		
		return "ex02Bean";
	}
	
	@GetMapping
	public String ex03(TodoDTO todo) {
		log.info("todo : "+todo);
		return "ex03";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("servierTime", new java.util.Date());
		
		return "home";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto + "+dto);
		log.info("page : "+page);
		
		return "/sample/ex04";
		
	}

}
