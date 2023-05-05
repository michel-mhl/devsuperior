package com.devsuperior.demo.services;

import com.devsuperior.demo.entities.Product;
import com.devsuperior.demo.reposotories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProduct() {
        List<Product> lista = productRepository.findAll();
        return lista;
    }

    public Optional<Product> getIdProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product;

    }
}