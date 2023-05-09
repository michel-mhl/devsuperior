package com.devsuperior.demo.controller;

import com.devsuperior.demo.dto.ProductDTO;
import com.devsuperior.demo.entities.Product;
import com.devsuperior.demo.reposotories.ProductRepository;
import com.devsuperior.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;


/*    public ResponseEntity <List<Product>> findAll() {
        if(productService.getProduct().isEmpty()){
            return ResponseEntity.notFound().build();
        }
     //   System.out.println(productService.getProduct());
        return ResponseEntity.ok(productService.getProduct());
    }*/

    @GetMapping()
    public List<ProductDTO> findAll() {
        List<ProductDTO> products = productService.getProduct();
        return products;
    }

    @GetMapping(value = "/{id}")
/*    public ResponseEntity<?> findId(@PathVariable Long id) {
        Optional<Product> product = productService.getIdProduct(id);
        if (productService.getIdProduct(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        System.out.println(productService.getIdProduct(id));
        return ResponseEntity.ok().body(product);
    }*/
    public ProductDTO findId(@PathVariable Long id) {
        ProductDTO result = productService.getIdProduct(id);
        return result;
    }

    @PostMapping
    public ResponseEntity<Product> criarProduto(@RequestBody Product product) {
        Product newProduct = productService.create(product);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path(newProduct.getName()).build().toUri();

        return ResponseEntity.created(uri).body(newProduct);
    }
}



