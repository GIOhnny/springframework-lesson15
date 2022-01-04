package ro.giohnnysoftware.springframeworklesson15.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ro.giohnnysoftware.springframeworklesson15.model.Product;

@RestController
public class ProductController {
    @GetMapping("/product/{name}")
    public Product getProduct(@PathVariable String name) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(10);
        
        return p;
    }
}
