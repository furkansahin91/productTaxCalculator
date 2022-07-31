package com.furkan.taxcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Product {
    public String name;
    public ProductCategory productCategory;
    public BigDecimal price;
    public BigDecimal tax;
    public BigDecimal salesPrice;
    public boolean isImported = false;


    public Product(String name, ProductCategory productCategory, BigDecimal price, boolean isImported) {
        this.name = name;
        this.productCategory = productCategory;
        this.price = price;
        this.isImported = isImported;
    }

    @Override
    public String toString() {
        return "1 " + isImportedToString() + name + ": " + salesPrice;
    }

    private String isImportedToString() {
        if (this.isImported) {
            return "Imported ";
        }
        return "";
    }
}
