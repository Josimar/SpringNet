package com.josimas.projectone.repositories;

import com.josimas.projectone.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
