package nz.co.goodspeed.chargenetbe.controller;

import com.nimbusds.jwt.JWTParser;
import nz.co.goodspeed.chargenetbe.model.JwtUser;
import nz.co.goodspeed.chargenetbe.model.Product;
import nz.co.goodspeed.chargenetbe.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin", consumes = "application/json", produces = "application/json")
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
    public void addProduct(@AuthenticationPrincipal Jwt principal,@RequestBody Product input) {
        JwtUser jwtUser = new JwtUser(principal);
        input.setCreatedBy(jwtUser.getUser());
        productRepository.save(input);
    }

    @PutMapping(value = "product-collection")

    public void addProduct(@AuthenticationPrincipal Jwt principal, @RequestBody List<Product> input) {

        JwtUser jwtUser = new JwtUser(principal);
        input.forEach(
                i -> i.setCreatedBy(jwtUser.getUser())
        );
        productRepository.saveAll(input);
    }

    @DeleteMapping("product/{id}")
    public void deleteProduct(@PathVariable("id") Integer id) {
        productRepository.deleteById(id);
    }
}
