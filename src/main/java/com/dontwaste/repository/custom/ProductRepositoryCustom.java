package com.dontwaste.repository.custom;

import com.dontwaste.model.web.search.ProductSearchRequest;
import com.dontwaste.model.web.search.ProductSearchResponse;

import java.util.List;

public interface ProductRepositoryCustom {

    List<ProductSearchResponse> fullProductSearch(ProductSearchRequest searchRequest);

}
