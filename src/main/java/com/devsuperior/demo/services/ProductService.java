package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.ProductDTO;
import com.devsuperior.demo.entities.Product;
import com.devsuperior.demo.reposotories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ProductService {
    private static final Logger LOGGER = Logger.getLogger(ProductService.class.getName());
    @Autowired
    private ProductRepository productRepository;
    @Transactional(readOnly = true)
    public List<ProductDTO> getProduct() {
        List<Product> lista = productRepository.findAll();
        return lista.stream().map(ProductDTO::new).toList();
    }

/*    @Transactional(readOnly = true)*/
/*    public Optional<Product> getIdProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product;

    }*/
    @Transactional(readOnly = true)
    public ProductDTO getIdProduct(Long id) {
       Product product = productRepository.findById(id).get();
        return new ProductDTO(product);

    }
    public Product create(Product product){
        Product productCreate = productRepository.save(product);
        LOGGER.info("Produdo:{} "+ product.getName()+ " Criado com sucesso ");
        return productCreate;
    }

}