package com.example.pafdemo21.model;

public class Book {

    private String book_id;
    private String title;
    private String authors;
    private String description;
    private String format;
    private Integer pages;
    private Float rating;
    private String genres;
    private String image_url;

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Book() {
    }

    public Book(String book_id, String title, String authors, String description, String format, Integer pages,
            Float rating, String genres, String image_url) {
        this.book_id = book_id;
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.format = format;
        this.pages = pages;
        this.rating = rating;
        this.genres = genres;
        this.image_url = image_url;
    }
}
