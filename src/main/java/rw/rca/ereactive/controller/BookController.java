package rw.rca.ereactive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rw.rca.ereactive.model.Book;
import rw.rca.ereactive.service.BookService;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public Flux<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Book>> getBook(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Book>> createBook(@RequestBody Book book) {
        return bookService.createBook(book)
                .map(b -> new ResponseEntity<>(b, HttpStatus.CREATED));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id)
                .thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}
