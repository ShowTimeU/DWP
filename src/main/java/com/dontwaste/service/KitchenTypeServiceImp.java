package com.dontwaste.service;

import com.dontwaste.model.entity.product.productType.KitchenType;
import com.dontwaste.repository.productTypes.KitchenTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KitchenTypeServiceImp implements KitchenTypeService {
    @Autowired
    KitchenTypeRepository kitchenTypeRepository;
    @Override
    public List<KitchenType> getAllKitchenTypes() {
        return kitchenTypeRepository.findAll();
    }
}
