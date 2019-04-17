package com.olehpodolin.recipeproject.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    public Ingredient() {}

    public Ingredient(BigDecimal amount, UnitOfMeasure unitOfMeasure, String description) {
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitOfMeasure;

}
