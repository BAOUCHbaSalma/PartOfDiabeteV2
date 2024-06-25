package com.diabete.diabete.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Repas")
public class Repas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer repasId;

    @Column
    private String repasName;

    @Column
    private String repasDescription;

    @Column
    private String recette;

    @Column
    private Double glicydes;

    @Column
    private Double carbs;

    @Column
    private Double gl;

    @Column
    private Double protein;

    @Column
    private Double kcal;

    @Column
    private String tauxglicemie;

    @Column
    private Double maxGl;

    @Column
    private String Picture;

    @Override
    public String toString() {
        return "Repas{" +
                "repasId=" + repasId +
                ", repasName='" + repasName + '\'' +
                ", repasDescription='" + repasDescription + '\'' +
                ", recette='" + recette + '\'' +
                ", glicydes=" + glicydes +
                ", carbs=" + carbs +
                ", gl=" + gl +
                ", protein=" + protein +
                ", kcal=" + kcal +
                ", tauxglicemie='" + tauxglicemie + '\'' +
                ", maxGl=" + maxGl +
                '}';
    }
}
