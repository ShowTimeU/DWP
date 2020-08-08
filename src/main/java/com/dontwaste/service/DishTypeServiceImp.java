package com.dontwaste.service;

import com.dontwaste.model.entity.product.productType.DishType;
import com.dontwaste.repository.productTypes.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DishTypeServiceImp implements DishTypeService {
    @Autowired
    DishTypeRepository dishTypeRepository;

    @Override
    public List<DishType> getAllDishTypes() {
        return dishTypeRepository.findAll();
    }
}
