package com.fotovacreation.springMVC.model;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class ProductDto
{
    private String name;
    private float price;
}
