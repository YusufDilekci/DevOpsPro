package com.example.devOpsPersonInfo.api.controllers;

import com.example.devOpsPersonInfo.business.abstracts.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {
    private PersonService personService;
    @GetMapping("/")

    public String index(Model model) {
        var persons = personService.getAll();
        model.addAttribute("persons", persons);
        return "home/index.html";
    }


}
