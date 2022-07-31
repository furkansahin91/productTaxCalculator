package com.furkan.taxcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCategory {
    public String category;
    public Double tax;
}
