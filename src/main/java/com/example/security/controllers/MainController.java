package com.example.security.controllers;

import com.example.security.User;
import com.example.security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class MainController {

    private UserRepository repository;

    @Autowired
    public MainController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/statistic")
    public String getEntriesPage(Model model, @RequestParam(value  = "login")  String login,
                                 @RequestParam(value  = "dateFrom") @DateTimeFormat(pattern = "yyyy-MM-dd") String dateFrom,
                                 @RequestParam(value  = "dateTo") @DateTimeFormat(pattern = "yyyy-MM-dd") String dateTo) {
        User user = repository.getCountOfEntries(login, Date.valueOf(dateFrom), Date.valueOf(dateTo));
        model.addAttribute("count", user.getCountEntries());
        return "statistic";
    }
}
