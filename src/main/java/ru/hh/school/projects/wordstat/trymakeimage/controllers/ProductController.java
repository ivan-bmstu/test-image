package ru.hh.school.projects.wordstat.trymakeimage.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.hh.school.projects.wordstat.trymakeimage.models.Product;
import ru.hh.school.projects.wordstat.trymakeimage.repositories.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String hello(){
        return "Hello world!";
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable int id){
        return productRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "product not found"));
    }
}
