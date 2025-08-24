package com.batch.example.BootBatchExample.Config;

import com.batch.example.BootBatchExample.model.Product;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) throws Exception {
        //transform ka logic yaha likhenge
        int discountedPercentage = Integer.parseInt(item.getDiscount());
        double originalPrice = Double.parseDouble(item.getPrice());
        double discount = (discountedPercentage/100)* originalPrice;
        double finalPrice = originalPrice - discount;
        item.setDiscounted_price(String.valueOf(finalPrice));
        return item;
    }
}
