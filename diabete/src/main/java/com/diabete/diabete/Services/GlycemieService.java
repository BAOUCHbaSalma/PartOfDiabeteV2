package com.diabete.diabete.Services;

import com.diabete.diabete.Models.Glycemie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface GlycemieService {
 void AddGlycemie(Glycemie glycemie);
 ArrayList<Glycemie> ShowGlycemie();
  ArrayList<Glycemie> searchByMonth(Integer month);
 ArrayList<Glycemie> searchByWeek(LocalDate startDate,LocalDate endDate);
 void Delete(Integer id);

}
