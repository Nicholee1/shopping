package org.learning.shopping.service;

import org.learning.shopping.entity.ProductInfo;

import java.util.List;

public interface ProductService {

     ProductInfo findOne(String productId);

     List<ProductInfo> findAll();
}
