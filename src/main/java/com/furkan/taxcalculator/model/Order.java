package com.furkan.taxcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    public String orderId;
    public List<Product> productList;
    public BigDecimal totalPrice;
    public BigDecimal totalTax;

    @Override
    public String toString() {
        return productList.toString() + " Sales taxes: " + totalTax + " Total: " + totalPrice;
    }
}
