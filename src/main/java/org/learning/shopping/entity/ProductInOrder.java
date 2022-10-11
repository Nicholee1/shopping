package org.learning.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class ProductInOrder implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Integer categoryType;

    @Min(1)
    private Integer count;

    @NotEmpty
    private String productDescription;

    @NotEmpty
    private String productIcon;

    @NotEmpty
    private String productId;

    @NotEmpty
    private String productName;

    @NotNull
    private BigDecimal productPrice;

    @Min(0)
    private Integer productStock;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY) //没有设置级联可能是因为历史订单，即使该订单被删除也需要保留？
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private OrderMain orderMain;

    @Override
    public String toString() {
        return "ProductInOrder{" +
                "id=" + id +
                ", categoryType=" + categoryType +
                ", count=" + count +
                ", productDescription='" + productDescription + '\'' +
                ", productIcon='" + productIcon + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productStock=" + productStock +
                '}';
    }
}
