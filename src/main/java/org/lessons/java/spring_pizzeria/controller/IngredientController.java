package org.lessons.java.spring_pizzeria.controller;

import org.lessons.java.spring_pizzeria.model.Ingredient;
import org.lessons.java.spring_pizzeria.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import jakarta.validation.Valid;

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

    @GetMapping("/create")
    public String create(Model model){

        model.addAttribute("ingredient", new Ingredient());
        return"ingredients/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("ingredient") Ingredient ingredient, 
    BindingResult bindingResult, 
    Model model){

        if(bindingResult.hasErrors()){
            return "ingredients/create-or-edit";
        }

        ingredientRepository.save(ingredient);

        return"redirect:/ingredients";
    }

}
