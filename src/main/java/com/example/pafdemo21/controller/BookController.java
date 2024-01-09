package com.example.pafdemo21.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pafdemo21.service.BookService;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    BookService svc;
    
    @GetMapping(path = "{id}")
    public String getBook(@PathVariable("id") String id, Model model) {

        model.addAttribute("book", svc.findBook(id));
        return "book";
    }
}
