package com.whitecastle.bookservice;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    
    @Operation(summary = "List all registered books")
    @GetMapping    
    public List<Book> listAll(){    
        return bookRepository.findAll();
    }

    @Operation(summary = "Save a new book")
    @Transactional
    @PostMapping
    public void createBook(@RequestBody Book book){
        bookRepository.save(book);
    }
    
    @Operation(summary = "Find a book by ISBN")
    @GetMapping("/{isbn}")
    public Optional<Book> readBook(@PathVariable Long isbn){
        return bookRepository.findById(isbn);
    }

    @Operation(summary = "Save book changes")
    @Transactional
    @PutMapping 
    public void updateBook(@RequestBody Book book){
        bookRepository.save(book);
    }
    
    @Operation(summary = "Delete book by ISBN")
    @Transactional
    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable Long isbn){
        if (bookRepository.findById(isbn).isPresent()) {
            bookRepository.deleteById(isbn);
        }        
    }

}
