package com.dontwaste.controller;

import com.dontwaste.model.web.productTemplate.ProductTemplateCreationRequest;
import com.dontwaste.model.web.productTemplate.ProductTemplateResponse;
import com.dontwaste.service.ProductTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/productTemplate")
public class ProductTemplateController {

    @Autowired
    ProductTemplateService productTemplateService;

    @PostMapping("/addTemplate")
    public void addProductTemplate(@RequestBody ProductTemplateCreationRequest productTemplateCreationRequest){
        productTemplateService.addProductTemplate(productTemplateCreationRequest);
    }

    @GetMapping("/getAllTemplates")
    public List<ProductTemplateResponse> getAllTemplates(@RequestParam Long institutionId){
        return productTemplateService.getAllProductTemplatesByInstitution(institutionId);
    }

    @GetMapping("/getTemplate")
    public ProductTemplateResponse getTemplate(@RequestParam Long id){
        return productTemplateService.getProductTemplate(id);
    }

    @DeleteMapping("/deleteTemplate")
    public void deleteTemplate(@RequestParam Long id){
        productTemplateService.deleteProductTemplate(id);
    }

}
