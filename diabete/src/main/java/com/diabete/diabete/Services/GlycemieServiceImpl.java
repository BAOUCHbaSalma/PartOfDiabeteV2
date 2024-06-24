package com.diabete.diabete.Services;

import com.diabete.diabete.Models.Glycemie;
import com.diabete.diabete.Repository.GlycemieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class GlycemieServiceImpl implements GlycemieService{

    @Autowired
    GlycemieRepository glycemieRepository;

    @Override
    public void AddGlycemie(Glycemie glycemie) {
        glycemieRepository.save(glycemie);
    }

    @Override
    public ArrayList<Glycemie> ShowGlycemie() {
        return (ArrayList<Glycemie>) glycemieRepository.findAll();
    }

    @Override
    public ArrayList<Glycemie> searchByMonth(Integer month) {
        return glycemieRepository.findByMonth(month);
    }
    @Override
    public ArrayList<Glycemie> searchByWeek(LocalDate startDate,LocalDate endDate) {
        return glycemieRepository.findByDateBetween(startDate,endDate);
    }

    @Override
    public void Delete(Integer id) {
        glycemieRepository.deleteById(id);
    }
}

