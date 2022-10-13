package org.learning.shopping.service;

import org.learning.shopping.entity.ProductInfo;

public interface ProductService {

     ProductInfo findOne(String productId);
}
