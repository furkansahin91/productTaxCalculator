package com.furkan.taxcalculator.service;

import com.furkan.taxcalculator.model.Order;
import com.furkan.taxcalculator.model.Product;
import com.furkan.taxcalculator.resource.ProductCategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    ProductCategoryRepository productRepository;
    @Autowired
    OrderService orderService;

    @Test
    public void testOrder() {
        List<Product> productList = new ArrayList<>();
        Product product = new Product("book", productRepository.findCategoryById("book"), BigDecimal.valueOf(12.49), false);
        productList.add(product);
        product = new Product("music CD", productRepository.findCategoryById("media"), BigDecimal.valueOf(14.99), false);
        productList.add(product);
        product = new Product("chocolate bar", productRepository.findCategoryById("food"), BigDecimal.valueOf(0.85), false);
        productList.add(product);

        Order invoice = orderService.createInvoice(productList);
        System.out.println(invoice.toString());

    }

    @Test
    public void testOrder2() {
        List<Product> productList = new ArrayList<>();

        Product product = new Product("bottle of perfume", productRepository.findCategoryById("cosmetics"), BigDecimal.valueOf(47.50), true);
        productList.add(product);
        product = new Product("box of chocolates", productRepository.findCategoryById("food"), BigDecimal.valueOf(10.00), true);
        productList.add(product);

        Order invoice = orderService.createInvoice(productList);
        System.out.println(invoice.toString());

    }

    @Test
    public void testOrder3() {
        List<Product> productList = new ArrayList<>();

        Product product = new Product("bottle of perfume", productRepository.findCategoryById("cosmetics"), BigDecimal.valueOf(27.99), true);
        productList.add(product);
        product = new Product("bottle of perfume", productRepository.findCategoryById("cosmetics"), BigDecimal.valueOf(18.99), false);
        productList.add(product);
        product = new Product("headache pills", productRepository.findCategoryById("medicine"), BigDecimal.valueOf(9.75), false);
        productList.add(product);
        product = new Product("box of chocolates", productRepository.findCategoryById("food"), BigDecimal.valueOf(11.25), true);
        productList.add(product);

        Order invoice = orderService.createInvoice(productList);
        System.out.println(invoice.toString());

    }
}
