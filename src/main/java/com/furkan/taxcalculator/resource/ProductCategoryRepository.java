package com.furkan.taxcalculator.resource;

import com.furkan.taxcalculator.model.ProductCategory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductCategoryRepository {
    private static ConcurrentHashMap<String, ProductCategory> productCategory = new ConcurrentHashMap<>();

    @PostConstruct
    void init() {
        productCategory.put("book", new ProductCategory("book", 0d));
        productCategory.put("medicine", new ProductCategory("medicine", 0d));
        productCategory.put("food", new ProductCategory("food", 0d));
        productCategory.put("cosmetics", new ProductCategory("cosmetics", 10d));
        productCategory.put("electronics", new ProductCategory("electronics", 10d));
        productCategory.put("media", new ProductCategory("media", 10d));
    }

    public ProductCategory findCategoryById(String id) {
        return productCategory.get(id);
    }
}
