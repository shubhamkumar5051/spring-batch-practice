package com.batch.example.BootBatchExample.Config;

import com.batch.example.BootBatchExample.model.Products;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Products, Products> {
    @Override
    public Products process(Products item) throws Exception {
        //transform ka logic yaha likhenge
       try{
           int discountedPercentage = Integer.parseInt(item.getDiscount().trim());
           double originalPrice = Double.parseDouble(item.getPrice().trim());
           double discount = (discountedPercentage/100)* originalPrice;
           double finalPrice = originalPrice - discount;
           item.setDiscounted_price(String.valueOf(finalPrice));
       }catch (
               NumberFormatException ex
       ){
           ex.getStackTrace();
       }
        return item;
    }
}
