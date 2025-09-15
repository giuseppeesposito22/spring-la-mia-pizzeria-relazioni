package org.lessons.java.spring_pizzeria.controller;

import org.lessons.java.spring_pizzeria.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository; 

    @GetMapping
    public String index(Model model){
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredients/index";
    }

}
