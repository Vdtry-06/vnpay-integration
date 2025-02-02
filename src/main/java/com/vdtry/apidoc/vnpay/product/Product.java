package com.vdtry.apidoc.vnpay.product;

import com.vdtry.apidoc.vnpay.category.Category;
import com.vdtry.apidoc.vnpay.core.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "products")
public class Product extends AbstractEntity {
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Min(value = 1, message = "Price must be greater than or equal to 1")
    @Column(name = "price")
    private double price;
    @Min(value = 0, message = "Stock must be greater than or equal to 0")
    @Column(name = "stock")
    private int stock;

    @NotEmpty(message = "Category is mandatory")
    @ManyToMany
    private Set<Category> categories;
}
