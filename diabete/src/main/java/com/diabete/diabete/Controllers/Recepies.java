package com.diabete.diabete.Controllers;

import com.diabete.diabete.Models.Glycemie;
import com.diabete.diabete.Models.Repas;
import com.diabete.diabete.Services.GlycemieServiceImpl;
import com.diabete.diabete.Services.RepasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class Recepies {
    @Autowired
    GlycemieServiceImpl glycemieServiceImpl;
   @Autowired
   private RepasService repasService;
    @RequestMapping ("/Repas")
    public String Repas(Model model) {

        model.addAttribute("repas", new Repas());
        List<Repas> listrepas = repasService.findRepasByGroupeDiabete(1.1);
        model.addAttribute("listeRepas", listrepas);
        System.out.println(listrepas);
        return "Repashtml";
    }
    @RequestMapping("/tst")
    public String show(Model model){
        model.addAttribute("Glycemi",new Glycemie());
        model.addAttribute("Glycemiss",glycemieServiceImpl.ShowGlycemie());
        return "testPage";
    }
    @RequestMapping("/Addtst")
public String Add(@ModelAttribute Glycemie glycemie){
    glycemieServiceImpl.AddGlycemie(glycemie);
    return "redirect:/testPage";
}
}
