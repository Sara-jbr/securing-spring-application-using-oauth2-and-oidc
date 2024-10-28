package com.saraco.bookservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("books")
class BookController {

    private static final Map<String, Book> books = new HashMap<>();

    static {
        var book1 = new Book("978-0-06-230123-9", "The Alchemist by Paulo Coelho");
        var book2 = new Book("978-1-4028-9467-2", "The Great Gatsby by F. Scott Fitzgerald");
        books.put(book1.getIsbn(), book1);
        books.put(book2.getIsbn(), book2);
    }

    @GetMapping
    Collection<Book> getBooks() {
        return books.values();
    }

    @GetMapping("{isbn}")
    Optional<Book> getBookIsbn(@PathVariable String isbn) {
        return Optional.of(books.get(isbn));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Book createBook(@RequestBody Book book) {
        books.put(book.getIsbn(), book);
        return book;
    }

}
