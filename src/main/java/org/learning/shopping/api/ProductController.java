package org.learning.shopping.api;

import io.swagger.annotations.Api;
import org.learning.shopping.entity.ProductInfo;
import org.learning.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/{productId}")
    public ProductInfo showOne(@PathVariable("productId") String productId){
        return productService.findOne(productId);
    }

    @GetMapping("/product")
    public List<ProductInfo> findAll(){

        return productService.findAll();
    }
}
