package com.example.pafdemo21.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pafdemo21.model.Book;
import com.example.pafdemo21.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository repo;

    public List<Book> getBookByPage(Integer page) {

        Integer offset = (page - 1) * 20;
        return repo.getBooksByPage(offset);
    }

    public Book findBook(String id) {
        return repo.findBookById(id);
    }

    public Integer getCount() {
        return repo.getCount();
    }
}
