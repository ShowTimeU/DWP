package com.dontwaste.controller;

import com.dontwaste.model.entity.product.productType.DishType;
import com.dontwaste.model.entity.product.productType.KitchenType;
import com.dontwaste.service.DishTypeService;
import com.dontwaste.service.KitchenTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductTypeController {

    @Autowired
    KitchenTypeService kitchenTypeService;
    @Autowired
    DishTypeService dishTypeService;

    @GetMapping("/getKitchenTypes")
    public List<KitchenType> getKitchenTypes(){
        return kitchenTypeService.getAllKitchenTypes();
    }

    @GetMapping("/getDishTypes")
    public List<DishType> getDishTypes(){
        return dishTypeService.getAllDishTypes();
    }

}
