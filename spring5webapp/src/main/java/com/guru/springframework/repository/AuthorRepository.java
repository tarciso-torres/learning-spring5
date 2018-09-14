package com.guru.springframework.repository;

import org.springframework.data.repository.CrudRepository;

import com.guru.springframework.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
