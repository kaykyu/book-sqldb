package com.example.pafdemo21.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pafdemo21.service.BookService;

@Controller
@RequestMapping(path = "/")
public class IndexController {

    @Autowired
    BookService svc;

    @GetMapping()
    public String getIndex(@RequestParam(value = "page", required = false) Integer page, Model model) {

        model.addAttribute("bookList", svc.getBookByPage(1));

        if (page != null) {
            model.addAttribute("bookList", svc.getBookByPage(page));
            model.addAttribute("currPage", page);
        }

        model.addAttribute("total", svc.getCount());
        return "index";
    }
}
