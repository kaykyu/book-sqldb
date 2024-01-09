package com.example.pafdemo21.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pafdemo21.model.Book;
import com.example.pafdemo21.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository repo;

    private List<Book> books = new ArrayList<>();

    public void getAllBooks() {
        books = repo.getAllBooks();
        books.sort((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
    }

    public List<Book> getBookByPage(Integer page) {

        List<Book> display = new ArrayList<>();
        Integer toFind = (page - 1) * 20;
        Integer end = toFind + 20;
        if (end > getCount())
            end = getCount();        
        for (int i = toFind; i < end; i++) {
            display.add(books.get(i));
        }

        return display;
    }

    public Book findBook(String id) {
        return repo.findBookById(id);
    }

    public Integer getCount() {
        return repo.getCount();
    }
}
