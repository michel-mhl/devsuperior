package com.devsuperior.demo.controller;

import com.devsuperior.demo.entities.Product;
import com.devsuperior.demo.reposotories.ProductRepository;
import com.devsuperior.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/products")
public class ProductController {
 //   @Autowired
 //   private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @GetMapping()
    public ResponseEntity <List<Product>> findAll() {
        if(productService.getProduct().isEmpty()){
            return ResponseEntity.notFound().build();
        }
        System.out.println(productService.getProduct());
        return ResponseEntity.ok(productService.getProduct());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity <?> findId(@PathVariable Long id) {
        Optional<Product> product = productService.getIdProduct(id);
        if(productService.getIdProduct(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        System.out.println(productService.getIdProduct(id));
        return ResponseEntity.ok().body(product);
    }
}



