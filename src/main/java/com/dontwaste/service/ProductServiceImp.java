package com.dontwaste.service;

import com.dontwaste.converter.admin.ProductConverter;
import com.dontwaste.model.admin.request.ProductCreationRequest;
import com.dontwaste.model.admin.response.ProductCreationResponse;
import com.dontwaste.model.customer.entity.Institution;
import com.dontwaste.model.customer.entity.product.Product;
import com.dontwaste.model.customer.web.product.ProductSearchObject;
import com.dontwaste.repository.InstitutionRepository;
import com.dontwaste.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService  {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductConverter productConverter;

    @Autowired
    InstitutionRepository institutionRepository;

    @Override
    public ProductCreationResponse createProduct(ProductCreationRequest productCreationRequest) {
        Institution institution = institutionRepository.findById(productCreationRequest.getInstitutionId()).get();
        if(institution == null){
            throw new RuntimeException("Wrong institution");
        }

        Product product = productConverter.converterToEntity(productCreationRequest, institution);

        productRepository.save(product);

        return productConverter.convertProductToWeb(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductWithPriceBetween(Double min, Double max) {
        return productRepository.getAllProductsWithPriceBetween(min, max);
    }

    @Override
    public List<Product> getAllProductsByNameLike(String name) {
        return productRepository.getAllProductsByNameLike(name);
    }

//    @Override
//    public List<Product> fullSearch(ProductSearchObject searchObject) {
//        return productRepository.fullProductSearch(searchObject);
//    }

//    @Override
//    public List<Product> getProductsByArea(String area) {
//        return productRepository.findAllByArea(area);
//    }
}
