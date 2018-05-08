package com.example.demo.web;

import com.example.demo.vo.TwitterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.EsRepository;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/es")
public class EsController {

	@Autowired
	EsRepository esRepository;

	@RequestMapping("/get")
	public void getResponse(Model model,
							@ModelAttribute("Twitter")TwitterVO vo) {
		model.addAttribute("data",esRepository.get(vo));
	}

	@RequestMapping("/put")
	public void put(Model model,
					@ModelAttribute("Twitter")TwitterVO vo) throws IOException, ExecutionException, InterruptedException {
		model.addAttribute("data",esRepository.update(vo));

	}

	@RequestMapping("/delete")
	public void delete(Model model,
					@ModelAttribute("Twitter")TwitterVO vo){
		model.addAttribute("data",esRepository.delete(vo));
	}



}
