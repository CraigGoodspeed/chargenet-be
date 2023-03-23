package nz.co.goodspeed.chargenetbe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
