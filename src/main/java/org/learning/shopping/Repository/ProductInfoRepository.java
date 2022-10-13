package org.learning.shopping.Repository;

import org.learning.shopping.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    ProductInfo findByProductId(String id);
}
