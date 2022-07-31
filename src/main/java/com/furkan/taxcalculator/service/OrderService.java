package com.furkan.taxcalculator.service;

import com.furkan.taxcalculator.model.Order;
import com.furkan.taxcalculator.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    public static final int IMPORT_TAX = 5;

    public Order createInvoice(List<Product> orderProducts) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        BigDecimal totalTax = BigDecimal.ZERO;
        for (Product product : orderProducts) {
            product.setTax(calculateTax(product));
            product.setSalesPrice(product.getTax().add(product.getPrice()));
            totalPrice = totalPrice.add(product.getSalesPrice());
            totalTax = totalTax.add(calculateTax(product));
        }
        return new Order(UUID.randomUUID().toString(), orderProducts, totalPrice,
                totalTax);
    }

    private BigDecimal calculateTax(Product product) {
        double productTax = product.getProductCategory().getTax() + (product.isImported ? IMPORT_TAX : 0);
        double taxPercentage = productTax / 100;
        return round(product.getPrice().multiply(BigDecimal.valueOf(taxPercentage)));
    }

    private BigDecimal round(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(2)).setScale(1, RoundingMode.UP).divide(BigDecimal.valueOf(2));
    }
}
