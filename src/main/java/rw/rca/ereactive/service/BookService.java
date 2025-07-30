package rw.rca.ereactive.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rw.rca.ereactive.model.Book;
import rw.rca.ereactive.repository.BookRepository;

@Service
@RequiredArgsConstructor
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Mono<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Mono<Book> createBook(Book book) {
        return bookRepository.save(book);
    }

    public Mono<Void> deleteBook(Long id) {
        return bookRepository.deleteById(id);
    }
}
