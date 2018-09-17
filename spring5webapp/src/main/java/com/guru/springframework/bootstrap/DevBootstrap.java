package com.guru.springframework.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.guru.springframework.model.Author;
import com.guru.springframework.model.Book;
import com.guru.springframework.model.Publisher;
import com.guru.springframework.repository.AuthorRepository;
import com.guru.springframework.repository.BookRepository;
import com.guru.springframework.repository.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();

	}

	private void initData() {
		
		Publisher publischer = new Publisher();
		publischer.setName("foo");
		
		publisherRepository.save(publischer);
		
		//Eric
		Author eric = new Author("Eric","Evans");
		Book ddd = new Book("Domain Drive Design", "1234", publischer);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		// Rod
		Author rod = new Author("Rood", "Jonhson");
		Book noEJB = new Book("J2EE Development without EJB", "23233", publischer);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
	}

}
