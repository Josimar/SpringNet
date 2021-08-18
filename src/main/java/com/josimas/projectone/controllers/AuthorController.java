package com.josimas.projectone.controllers;

import com.josimas.projectone.model.Author;
import com.josimas.projectone.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping(value = "/{authors}", method = RequestMethod.GET)
    public String getAuthors(Model model){

        model.addAttribute("authors", authorRepository.findAll());

        return "author/list";
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    public Iterable<Author> getBrand(@PathVariable Integer id) {
        return authorRepository.findAll();
    }

}
