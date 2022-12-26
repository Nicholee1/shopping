package org.learning.shopping.service.impl;

import org.learning.shopping.Repository.ProductInfoRepository;
import org.learning.shopping.entity.ProductInfo;
import org.learning.shopping.enums.ResultEnum;
import org.learning.shopping.exception.MyException;
import org.learning.shopping.service.CategoryService;
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
    @Autowired
    CategoryService categoryService;

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
        return productInfoRepository.findAllByCategoryType(categoryType, pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return update(productInfo);
    }

    @Override
    public ProductInfo update(ProductInfo productInfo) {
        categoryService.findAllByCategoryType(productInfo.getCategoryType());

        if (productInfo.getProductStatus() > 1) {
            throw new MyException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        return productInfoRepository.save(productInfo);
    }

    @Override
    public void delete(String id) {
        ProductInfo one = findOne(id);
        if(id==null){
            throw new MyException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        productInfoRepository.delete(one);
    }
}
