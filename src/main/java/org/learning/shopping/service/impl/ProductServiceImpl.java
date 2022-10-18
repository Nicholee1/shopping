package org.learning.shopping.service.impl;

import org.learning.shopping.Repository.ProductInfoRepository;
import org.learning.shopping.entity.ProductInfo;
import org.learning.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo productInfo = productInfoRepository.findByProductId(productId);
        return productInfo;
    }

    @Override
    public List<ProductInfo> findAll() {
        return productInfoRepository.findAll();
    }
}
