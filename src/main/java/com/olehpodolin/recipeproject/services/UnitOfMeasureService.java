package com.olehpodolin.recipeproject.services;

import com.olehpodolin.recipeproject.domain.UnitOfMeasure;
import com.olehpodolin.recipeproject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnitOfMeasureService {

    private UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureService(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    public UnitOfMeasure getUnitOfMeasure(String description) {
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByUom(description);
        return unitOfMeasureOptional.get();
    }

}
