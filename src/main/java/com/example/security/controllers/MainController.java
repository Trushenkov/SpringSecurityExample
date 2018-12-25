package com.example.security.controllers;

import com.example.security.Person;
import com.example.security.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class MainController {

    private PersonRepository repository;

    @Autowired
    public MainController(PersonRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/statistic")
    public String getEntriesPage(Model model, @RequestParam(value  = "login")  String login,
                                 @RequestParam(value  = "dateFrom") @DateTimeFormat(pattern = "yyyy-MM-dd") String dateFrom,
                                 @RequestParam(value  = "dateTo") @DateTimeFormat(pattern = "yyyy-MM-dd") String dateTo) {
        Person person = repository.getCountOfEntries(login, Date.valueOf(dateFrom), Date.valueOf(dateTo));
        model.addAttribute("count", person.getCountEntries());
        return "statistic";
    }
}
