package com.dontwaste.repository.custom;

import org.springframework.stereotype.Repository;

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
