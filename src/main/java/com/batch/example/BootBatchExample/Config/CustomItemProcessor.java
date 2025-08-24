package com.batch.example.BootBatchExample.Config;

import com.batch.example.BootBatchExample.model.Product;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) throws Exception {
        return null;
    }
}
