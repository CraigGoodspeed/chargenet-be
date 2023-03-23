package nz.co.goodspeed.chargenetbe.controller;

import nz.co.goodspeed.chargenetbe.model.JwtUser;
import nz.co.goodspeed.chargenetbe.model.Product;
import nz.co.goodspeed.chargenetbe.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class Admin {

    final ProductRepository productRepository;

    @Autowired
    public Admin(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("product/info")
    public String zaza() {
        return "------ADMIN-----";
    }

    @PutMapping("product")
    public void addProduct(@RequestHeader("Authorization") String token, Product input) {
        JwtUser jwtUser = new JwtUser(token);
        input.setCreatedBy(jwtUser.getUser());
        productRepository.save(input);
    }

    @DeleteMapping("product/{id}")
    public void deleteProduct(@PathVariable("id") Integer id) {
        productRepository.deleteById(id);
    }
}
