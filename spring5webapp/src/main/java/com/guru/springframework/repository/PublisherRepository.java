package com.guru.springframework.repository;

import org.springframework.data.repository.CrudRepository;

import com.guru.springframework.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
