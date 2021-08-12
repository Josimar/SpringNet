package com.josimas.projectone.repositories;

import com.josimas.projectone.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
