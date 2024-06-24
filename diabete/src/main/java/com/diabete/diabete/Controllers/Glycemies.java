package com.diabete.diabete.Controllers;

import com.diabete.diabete.Models.Glycemie;

import com.diabete.diabete.Services.GlycemieService;
import com.diabete.diabete.Services.GlycemieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class Glycemies {
    @Autowired
    GlycemieService glycemieService;
    @RequestMapping("/")
    public String show(Model model){
        model.addAttribute("Glycemie",new Glycemie());
        model.addAttribute("Glycemies",glycemieService.ShowGlycemie());
        return "Dashbord";
    }
    @RequestMapping("/Add")
    public String Add(@ModelAttribute Glycemie glycemie){
       glycemieService.AddGlycemie(glycemie);
        return "redirect:/";
    }
    @RequestMapping("/Pdf")
    public String pdfGenerate(Model model){
        model.addAttribute("Glycemies",glycemieService.ShowGlycemie());
        return "Pdf";
    }

    @RequestMapping("/SearchM")
    public String searchByMonth(@RequestParam("month") Integer month, Model model) {
        ArrayList<Glycemie> records = glycemieService.searchByMonth(month);
        model.addAttribute("Glycemies", records);
        return "Dashbord";
    }

    @RequestMapping("/SearchW")
    public String searchByWeek(@RequestParam("startDate") LocalDate startDate,@RequestParam("endDate") LocalDate endDate, Model model) {
        ArrayList<Glycemie> records = glycemieService.searchByWeek(startDate,endDate);
        model.addAttribute("Glycemies", records);
        return "Dashbord";
    }
    @RequestMapping("/Delete/{id}")
    public String Delete(@PathVariable("id") Integer id){
        glycemieService.Delete(id);
        return "redirect:/";
    }
}
