package com.whitecastle.linkservice;

import java.util.List;

import com.whitecastle.linkservice.proxy.BooksProxy;
import com.whitecastle.linkservice.proxy.PhotosProxy;
import com.whitecastle.linkservice.response.Books;
import com.whitecastle.linkservice.response.Photos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Link endpoint")
@RestController
@RequestMapping
public class LinkserviceController {
    @Autowired
    private PhotosProxy photosProxy;

    @Autowired
    private BooksProxy booksProxy;
    
    @Operation(summary = "Find a list of images from a public site")
    @GetMapping("/photos")
    @Retry(name = "photos") //Resilience4j: # tentativas acesso definido em application.prop
    public List<Photos> getMagic() {
        return photosProxy.getPhotos().subList(1, 50);
    }
    
    @Operation(summary = "Find a specific image from a public site by ID")
    @GetMapping("/photos/{id}")    
    public Photos getMagicId(@PathVariable Integer id) {
        return photosProxy.getPhotoId(id);
    }
  
    @Operation(summary = "Find a list of books from through another microservice")
    @GetMapping("/books")
    @Retry(name = "default")
    public List<Books> getMagicBooks(){
        return booksProxy.getBooks();
    }

    @Operation(summary = "Find a list of books from through another microservice by ID")
    @GetMapping("/books/{id}")
    public Books getMagicBooksId(@PathVariable Integer id) {
        return booksProxy.getBooksId(id);
    }    

}
