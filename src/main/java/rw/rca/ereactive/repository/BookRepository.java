package rw.rca.ereactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import rw.rca.ereactive.model.Book;

public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
}
