package com.naina.naina_artistry.service;


import com.naina.naina_artistry.model.Product;
import com.naina.naina_artistry.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts() {
        return repo.findAllByOrderByIdAsc();
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public Product updateProduct(int id, Product updatedProduct) {

        Product product = repo.findById(id).orElseThrow();

        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setCategory(updatedProduct.getCategory());
        product.setImageUrl(updatedProduct.getImageUrl());
        product.setStock(updatedProduct.getStock());

        return repo.save(product);
    }
}