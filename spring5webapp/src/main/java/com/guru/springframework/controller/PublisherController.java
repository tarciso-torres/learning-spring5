package com.guru.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guru.springframework.repository.PublisherRepository;

@Controller
public class PublisherController {
	
	private PublisherRepository publisherRepository;

	public PublisherController(PublisherRepository publisherRepository) {
		super();
		this.publisherRepository = publisherRepository;
	}
	
	@RequestMapping("/publishers")
	public String getPublishers(Model model) {
		model.addAttribute("publishers", publisherRepository.findAll());
		return "publishers";
	}

}
