package com.guru.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guru.springframework.repository.AuthorRepository;

@Controller
public class AuthorController {
	
	private AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		
		return "authors";
	}

}
