package com.josimas.projectone.bootstrap;

import com.josimas.projectone.model.Author;
import com.josimas.projectone.model.Book;
import com.josimas.projectone.repositories.AuthorRepository;
import com.josimas.projectone.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author author = new Author("Josimar", "Silva");
        Book book = new Book("Você faz a diferença", "9784377508956");
        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);

        author = new Author("Josimas", "Silva");
        book = new Book("Como ser ágil", "9784377508956");
        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
    }
}
