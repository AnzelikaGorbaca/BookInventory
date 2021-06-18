package com.company.Book.Invenory.controller;

import com.company.Book.Invenory.dao.BookDAO;
import com.company.Book.Invenory.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller

@RequestMapping("/books")
public class BookController {

        private final BookDAO BookDAO;

        @Autowired
        public BookController(BookDAO BookDAO) {
            this.BookDAO = BookDAO;
        }

        @GetMapping()
        public String index(Model model) {
            model.addAttribute("books", BookDAO.index());
            return "books/index";
        }

        @GetMapping("/{id}")
        public String show(@PathVariable("id") int id, Model model) {
            model.addAttribute("book", BookDAO.show(id));
            return "books/show";
        }

        @GetMapping("/new")
        public String newPerson(@ModelAttribute("book") Book book) {
            return "books/new";
        }

        @PostMapping()
        public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                return "books/new";
            }

            BookDAO.save(book);
            return "redirect:/books";
        }

        @GetMapping("/{id}/edit")
        public String edit(Model model, @PathVariable("id") int id) {
            model.addAttribute("book", BookDAO.show(id));
            return "books/edit";
        }

        @PostMapping("/{id}")
        public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult,
                             @PathVariable("id") int id) {
            if (bindingResult.hasErrors()) {
                return "books/edit";
            }
            BookDAO.update(id, book);
            return "redirect:/books";
        }

        @PostMapping("/{id}/delete")
        public String delete(@PathVariable("id") int id) {
            BookDAO.delete(id);
            return "redirect:/books";
        }
    }

