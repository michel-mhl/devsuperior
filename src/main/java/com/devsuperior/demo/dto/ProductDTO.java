package com.devsuperior.demo.dto;

import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.entities.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProductDTO {
    private  Long id;
    private  String name;
    private  Double price;

    private Department department;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.department = product.getDepartment();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public ProductDTO(Long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }
}
