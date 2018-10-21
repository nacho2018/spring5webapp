package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");

        //Andrews
        Publisher andrews = new Publisher("Andrews Robins", "34, Penny Rd. London UK");
        Book ddd = new Book("Domain Driven Design", "1234", andrews);
        eric.getBooks().add(ddd);

        authorRepository.save(eric);
        publisherRepository.save(andrews);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");

        //Laura
        Publisher laura = new Publisher("Laura Williams", "11, Roses Av. N.Y. USA");
        Book noEJB = new Book("J2EE Development without EJB", "23444", laura);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        publisherRepository.save(laura);
        bookRepository.save(noEJB);
    }


}
