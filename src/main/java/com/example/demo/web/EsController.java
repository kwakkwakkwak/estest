package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.EsRepository;

@Controller
@RequestMapping("/es")
public class EsController {
	
	@Autowired
	EsRepository esRepository;
	
	@RequestMapping("/get")
	public void getResponse(Model model,
			@ModelAttribute("index") String index,
			@ModelAttribute("type") String type,
			@ModelAttribute("id") String id) {

		
		model.addAttribute("data",esRepository.getResponse(index,type,id));
		
	}
	

}
