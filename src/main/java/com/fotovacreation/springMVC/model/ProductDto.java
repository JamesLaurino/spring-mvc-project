package com.fotovacreation.springMVC.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class ProductDto
{
    @NotEmpty(message = "A product must have a name")
    private String name;

    @Min(value = 0, message = "A product must have a price")
    private float price;
}
