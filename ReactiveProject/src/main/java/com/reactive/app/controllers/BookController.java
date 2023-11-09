package com.reactive.app.controllers;

import com.reactive.app.entities.Book;
import com.reactive.app.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    //    create
    @PostMapping
    public Mono<Book> create(@RequestBody Book book) {
        LOGGER.info("@@@ create Book Request :::");
        return bookService.create(book);
    }

    //    get all books
    @GetMapping
    public Flux<Book> getAll() {
        LOGGER.info("@@@ get All Book Request :::");
        return bookService.getAll();
    }

    //    get single book
    @GetMapping("/{bid}")
    public Mono<Book> get(@PathVariable("bid") int bookId) {
        LOGGER.info("@@@ get Book by id Request :::");
        return bookService.get(bookId);
    }

//    update
    @PutMapping("/{bookId}")
    public Mono<Book> update(@RequestBody Book book, @PathVariable int bookId) {
        LOGGER.info("@@@ update Book by id Request :::");
        return bookService.update(book,bookId);
    }

//    delete
    @DeleteMapping("/{bookId}")
    public  Mono<Void> delete(@PathVariable int bookId){
        LOGGER.info("@@@ delete Book by id Request :::");
        return bookService.delete(bookId);
    }
}
