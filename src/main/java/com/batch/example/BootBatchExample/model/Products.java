package com.batch.example.BootBatchExample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
 private int product_id;
 private String title;
 private String description;
 private String price;
 private String discount;
 private String discounted_price;
}
