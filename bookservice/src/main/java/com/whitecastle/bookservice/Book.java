package com.whitecastle.bookservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity(name = "book") //Não usaremos @Column. Atributos tem mesmo nome dos campos
public class Book implements Serializable { //Garantir que a instancia do objeto seja persistido
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long isbn;

    private String title;
    private Integer edition;
    private String author;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Type type;
    
    public Book() { }

    public Book(Long isbn, String title, Integer edition, String author, Category category, Type type) {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.author = author;
        this.category = category;
        this.type = type;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    
}
