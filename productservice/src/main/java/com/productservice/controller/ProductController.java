package com.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.productservice.model.Product;
import com.productservice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService, ProductService productService1) {

        this.productService = productService1;
    }

    @GetMapping(value = "/list")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping(value = "/add")
    public String addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping(value = "/{ProductID}")
    public String deleteProduct(@PathVariable String productID) {
        return productService.deleteProduct(productID);
    }

    @PutMapping(value = "/{ProductID}")
    public Product updateProduct(@RequestBody Product product, @PathVariable String productID) {
        return productService.updateProduct(product, productID);
    }

}

