package nz.co.goodspeed.chargenetbe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/product")
public class Product {
    @GetMapping("info")
    public String getInfo() {
        return "zaza";
    }
}
