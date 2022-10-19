package org.learning.shopping.service.impl;

import org.learning.shopping.Repository.ProductInOrderRepository;
import org.learning.shopping.service.ProductInOrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductInOrderServiceImpl implements ProductInOrderService {
    @Autowired
    ProductInOrderRepository productInOrderRepository;

}
