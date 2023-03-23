package nz.co.goodspeed.chargenetbe.controller;

import nz.co.goodspeed.chargenetbe.model.Product;
import nz.co.goodspeed.chargenetbe.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("info")
    public String getInfo() {
        return "----PRODUCT----";
    }

    @GetMapping("all")
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAllByOrderByDescriptionDesc());
    }





}
