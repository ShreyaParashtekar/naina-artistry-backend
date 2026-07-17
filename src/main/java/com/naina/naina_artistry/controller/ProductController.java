package com.naina.naina_artistry.controller;


    import com.naina.naina_artistry.model.Product;
    import com.naina.naina_artistry.service.ProductService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;
    import java.util.List;
    import jakarta.annotation.PostConstruct;

    @RestController
    @RequestMapping("/products")
    @CrossOrigin(origins = {
            "http://localhost:3000",
            "https://naina-artistry-frontend.onrender.com"
    })

    public class ProductController {

        @PostConstruct
        public void init() {
            System.out.println("***** PRODUCT CONTROLLER LOADED *****");
        }

        @Autowired
        private ProductService service;

        @GetMapping
        public List<Product> getProducts() {
            return service.getAllProducts();
        }

        @GetMapping("/test")
        public String test() {
            return "UPLOAD CONTROLLER WORKING";
        }

        @PostMapping
        public Product addProduct(@RequestBody Product product) {
            return service.addProduct(product);
        }

        @PutMapping("/{id}")
        public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
            return service.updateProduct(id, product);
        }
        @DeleteMapping("/{id}")
        public void deleteProduct(@PathVariable int id) {
            service.deleteProduct(id);
        }


    }