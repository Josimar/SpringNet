package com.josimas.projectone.bootstrap;

import com.josimas.projectone.model.Author;
import com.josimas.projectone.model.Book;
import com.josimas.projectone.model.Publisher;
import com.josimas.projectone.repositories.AuthorRepository;
import com.josimas.projectone.repositories.BookRepository;
import com.josimas.projectone.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("JBS Publishing");
        publisher.setCity("São Paulo");
        publisher.setState("SP");
        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());



        Author author = new Author("Josimar", "Silva");
        Book book = new Book("Você faz a diferença", "9784377508956");
        author.getBooks().add(book);
        book.getAuthors().add(author);

        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);


        author = new Author("Josimas", "Silva");
        book = new Book("Como ser ágil", "9784377508956");
        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);

        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher Number of books: " + publisher.getBooks().size());
    }
}
