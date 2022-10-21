package org.learning.shopping.service;

import org.learning.shopping.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

     ProductInfo findOne(String productId);

     Page<ProductInfo> findAll(Pageable pageable);

     Page<ProductInfo> findAllInCategory(Integer categoryType,Pageable pageable);
}
