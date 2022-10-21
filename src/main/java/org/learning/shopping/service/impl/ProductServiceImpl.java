package org.learning.shopping.service.impl;

import org.learning.shopping.Repository.ProductInfoRepository;
import org.learning.shopping.entity.ProductInfo;
import org.learning.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAllByOrderByProductId(pageable);
    }

    @Override
    public Page<ProductInfo> findAllInCategory(Integer categoryType, Pageable pageable) {
        return productInfoRepository.findAllByCategoryType(categoryType,pageable);
    }
}
