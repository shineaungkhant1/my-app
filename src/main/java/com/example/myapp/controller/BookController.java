package com.example.myapp.controller;

import com.example.myapp.ds.Category;
import com.example.myapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String test(Model model){
        model.addAttribute("category",new Category());
        return "layout/adminLayout.html";
    }

    @GetMapping("/category-form")
    public String categoryForm(Model model){
        model.addAttribute("category",new Category());
        return "category-Form";
    }

    @PostMapping("/save-category")
    public String saveCategory(Category category, BindingResult result){
        if (result.hasErrors()){
            return "category-Form";
        }
        bookService.saveCategory(category);
        return "redirect:/list-category";
    }

    @GetMapping("/list-category")
    public String listCategory(Model model){
        model.addAttribute("categories",bookService.findAllCategory());
        return "list-category";
    }
}
