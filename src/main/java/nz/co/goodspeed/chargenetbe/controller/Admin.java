package nz.co.goodspeed.chargenetbe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class Admin {
    @GetMapping("product/info")
    public String zaza() {
        return "------ADMIN-----";
    }
}
