package com.whitecastle.linkservice.proxy;

import java.util.List;

import com.whitecastle.linkservice.response.Books;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "bookservice")
public interface BooksProxy {
    
    @GetMapping("/books")
    List<Books> getBooks();

    @GetMapping("/books/{isbn}")
    Books getBooksId(@PathVariable Integer isbn);
}
