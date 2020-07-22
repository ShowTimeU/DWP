package com.dontwaste.repository.custom;

import com.dontwaste.model.customer.entity.product.Product;
import com.dontwaste.model.customer.web.product.ProductSearchObject;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom{

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<Product> fullProductSearch(ProductSearchObject searchObject) {
//
//        Map<String, Object> parameters = new HashMap<>();
//        StringBuilder query = new StringBuilder("select p, i from Product p, Institution i where 1=1");
//
//        if(searchObject.getProductName() != null){
//            query.append(" and p.productName = :productName");
//            parameters.put("productName", searchObject.getProductName());
//        }
//
//        if(searchObject.getMax() != null){
//            query.append(" and p.price between :min and :max");
//            parameters.put("min", searchObject.getMin());
//            parameters.put("max", searchObject.getMax());
//        }
//
//        if(searchObject.getCity() != null){
//            query.append(" and i.city = :city");
//            parameters.put("city", searchObject.getCity());
//        }
//
//        if(searchObject.getInstitutionName() != null){
//            query.append(" and i.institution = :institution");
//            parameters.put("institution", searchObject.getInstitutionName());
//        }
//
//        Query jpaQuery = entityManager.createQuery(query.toString());
//        for(Map.Entry<String, Object> map : parameters.entrySet()){
//            jpaQuery.setParameter(map.getKey(), map.getValue());
//        }
//
//        return jpaQuery.getResultList();
//    }
}
