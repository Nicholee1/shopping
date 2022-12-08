package org.learning.shopping.api;

import io.swagger.annotations.Api;
import org.learning.shopping.entity.ProductInfo;
import org.learning.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

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
    public Page<ProductInfo> findAll(@RequestParam(value = "page",defaultValue="1") Integer page,
                                     @RequestParam(value = "size",defaultValue="3") Integer size){
        PageRequest pageRequest= PageRequest.of(page-1,size);

        return productService.findAll(pageRequest);
    }
}
