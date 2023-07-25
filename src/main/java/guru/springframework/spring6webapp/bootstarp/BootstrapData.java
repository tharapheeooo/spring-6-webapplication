package guru.springframework.spring6webapp.bootstarp;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driver Design");
        ddd.setIsbn("12345678");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author eden = new Author();
        eden.setFirstName("Eden");
        eden.setLastName("Jhon");

        Book nodeJs = new Book();
        nodeJs.setTitle("Domain Driver Design Edition2");
        nodeJs.setIsbn("12345678");

        Author edenSaved = authorRepository.save(eden);
        Book nodeJsSaved = bookRepository.save(nodeJs);

        ericSaved.getBooks().add(dddSaved);
        edenSaved.getBooks().add(nodeJsSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(edenSaved);

        System.out.println("In bootstrap");
        System.out.println("Author Count:" + authorRepository.count());
        System.out.println("Book count : " + bookRepository.count());

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Hello Publisher");
        publisher.setAddress("Adachiku Japan");
        publisher.setCity("Tokyo");
        publisherRepository.save(publisher);

        System.out.println("Publisher Count : " + publisherRepository.count());




    }
}
