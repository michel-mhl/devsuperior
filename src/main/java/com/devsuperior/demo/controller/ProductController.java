package com.devsuperior.demo.controller;

import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.entities.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @GetMapping
    public List<Product> getObject() {
        Department d1 = new Department(1l,"Tech");
        Department d2 = new Department(2L,"Pet");
        Product p1 = new Product(1L,"Macbook Pro",4000.0,d1);
        Product p2 = new Product(2L,"PC Gamer",5000.0,d1);
        Product p3 = new Product(3L," Pet House",400.0,d2);

        List<Product> lista = Arrays.asList(p1,p2,p3);
        return lista;
    }
}



