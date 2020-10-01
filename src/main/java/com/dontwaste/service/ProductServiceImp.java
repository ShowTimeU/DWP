package com.dontwaste.service;

import com.dontwaste.converter.ProductConverter;
import com.dontwaste.exception.BranchNotFoundException;
import com.dontwaste.exception.TemplateNotFoundException;
import com.dontwaste.model.entity.ProductTemplate;
import com.dontwaste.model.entity.Branch;
import com.dontwaste.model.web.product.ProductCreationRequest;
import com.dontwaste.model.web.product.ProductResponse;
import com.dontwaste.model.entity.product.Product;
import com.dontwaste.model.web.search.ProductSearchRequest;
import com.dontwaste.model.web.search.ProductSearchResponse;
import com.dontwaste.repository.ProductRepository;
import com.dontwaste.repository.ProductTemplateRepository;
import com.dontwaste.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService  {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductConverter productConverter;
    @Autowired
    BranchRepository branchRepository;
    @Autowired
    ProductTemplateRepository productTemplateRepository;

    @Override
    public void addProduct(ProductCreationRequest productCreationRequest) {
        Branch branch = branchRepository.findById(productCreationRequest.getBranchId()).orElse(null);
        ProductTemplate productTemplate =
                productTemplateRepository.findById(productCreationRequest.getProductTemplateId()).orElse(null);
        if(branch == null){
            throw new BranchNotFoundException("branch is not exist");
        }
        if(productTemplate == null){
            throw new TemplateNotFoundException("wrong ProductTemplate");
        }
        Product product = productConverter.convertToEntity(productCreationRequest, branch, productTemplate);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> products = new ArrayList<>();
        List<Product> lp = productRepository.findAll();
        for(Product product : lp){
            products.add(productConverter.convertToWeb(product));
        }
//        productRepository.findAll().stream()
//                .map(product -> products.add(productConverter.convertToWeb(product)));
        return products;
    }

    @Override
    public List<ProductResponse> getAllActiveProducts() {
        List<ProductResponse> products = new ArrayList<>();
        List<Product> lp = productRepository.findAllByActiveTrue();
        for(Product product : lp){
            products.add(productConverter.convertToWeb(product));
        }
        return products;
    }

    @Override
    public List<ProductSearchResponse> searchProduct(ProductSearchRequest productSearchRequest) {
        return productRepository.fullProductSearch(productSearchRequest);
    }
}
