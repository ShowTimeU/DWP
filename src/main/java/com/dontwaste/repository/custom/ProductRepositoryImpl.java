package com.dontwaste.repository.custom;

import com.dontwaste.model.entity.Branch;
import com.dontwaste.model.entity.Institution;
import com.dontwaste.model.entity.ProductTemplate;
import com.dontwaste.model.entity.product.Product;
import com.dontwaste.model.entity.product.productType.DishType;
import com.dontwaste.model.entity.product.productType.KitchenType;
import com.dontwaste.model.web.search.ProductSearchRequest;
import com.dontwaste.model.web.search.ProductSearchResponse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductSearchResponse> fullProductSearch(ProductSearchRequest searchRequest) {
        List<ProductSearchResponse> results = new ArrayList<>();
        Map<String, Object> parameters = new HashMap<>();
        StringBuilder query = new StringBuilder("SELECT p, pt, i, b, dt, kt FROM " +
                "Product p, ProductTemplate pt, Institution i, Branch b, DishType dt, KitchenType kt " +
                "WHERE " +
                "p.productTemplate = pt AND p.branch = b AND pt.institution = i AND pt.dishType = dt AND " +
                "pt.kitchenType = kt AND b.institution = i");



        if(searchRequest.getMax() != null){
            query.append(" and p.price between :min and :max");
            parameters.put("min", searchRequest.getMin());
            parameters.put("max", searchRequest.getMax());
        }

        if(searchRequest.getProductName() != null){
            query.append(" and pt.productName = :productName");
            parameters.put("productName", searchRequest.getProductName());
        }

        if(searchRequest.isKosher()){
            query.append(" and pt.kosher = :kosher");
            parameters.put("kosher", searchRequest.isKosher());
        }

        if(searchRequest.isVegan()){
            query.append(" and pt.vegan = :vegan");
            parameters.put("vegan", searchRequest.isVegan());
        }

        if(searchRequest.isVegetarian()){
            query.append(" and pt.vegetarian = :vegetarian");
            parameters.put("vegetarian", searchRequest.isVegetarian());
        }

        if(searchRequest.getDishType() != null){
            query.append(" and dt.dishType = :dishType");
            parameters.put("dishType", searchRequest.getDishType());
        }

        if(searchRequest.getKitchenType() != null){
            query.append(" and kt.kitchenName = :kitchenName");
            parameters.put("kitchenName", searchRequest.getKitchenType());
        }

        if(searchRequest.getCity() != null){
            query.append(" and b.branchCity = :branchCity");
            parameters.put("branchCity", searchRequest.getCity());
        }

        if(searchRequest.getInstitutionName() != null){
            query.append(" and i.institutionName = :institutionName");
            parameters.put("institutionName", searchRequest.getInstitutionName());
        }
        System.out.println(query.toString());
        Query jpaQuery = entityManager.createQuery(query.toString());
        for(Map.Entry<String, Object> map : parameters.entrySet()){
            jpaQuery.setParameter(map.getKey(), map.getValue());
        }


        List<Object[]> jpaRes = jpaQuery.getResultList();
        System.out.println("jpaRes -> "+jpaRes.size());
        for(Object[] res : jpaRes){
            System.out.println(res.toString());
            for(int i = 0; i<res.length-1; i++){
                System.out.println(res[i].toString());
            }
            System.out.println("----------------------------------------");
        }
        Product product = new Product();
        for(Object[] res : jpaRes){
            product = (Product) res[0];
            results.add(ProductSearchResponse.builder()
            .startingPrice(product.getStartingPrice())
            .price(product.getPrice())
            .quantity(product.getQuantity())
            .productTemplate((ProductTemplate) res[1])
            .institution((Institution) res[2])
            .branch((Branch) res[3])
            .dishType((DishType) res[4])
            .kitchenType((KitchenType) res[5])
            .build());
        }

        System.out.println("results -> "+results.size());
//        return jpaQuery.getResultList();
        return results;
    }
}
