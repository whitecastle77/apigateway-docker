package com.whitecastle.linkservice.response;

public class Books {
    private Integer isbn;
    private String title;
    private Integer edition;
    private String author;
    private String category;
    private String type;

    public Books(){
        
    }

    public Books(Integer isbn, String title, Integer edition, String author, String category, String type) {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.author = author;
        this.category = category;
        this.type = type;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Books [author=" + author + ", category=" + category + ", edition=" + edition + ", isbn=" + isbn
                + ", title=" + title + ", type=" + type + "]";
    }

    
}
