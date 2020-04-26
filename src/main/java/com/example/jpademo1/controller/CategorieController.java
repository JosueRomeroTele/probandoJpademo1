package com.example.jpademo1.controller;

import com.example.jpademo1.entity.Categorie;
import com.example.jpademo1.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    CategorieRepository categorieRepository;
    @GetMapping(value = {"","/listaCategory"})
    public String listCate(Model model){
        List<Categorie> listCate = categorieRepository.findAll();
        model.addAttribute("listaCategoria",listCate);
        return "/category/listaCat";
    }


}
