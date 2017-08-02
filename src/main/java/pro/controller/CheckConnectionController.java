package pro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckConnectionController {

    @RequestMapping(value = "/test")
    public String test() {
        return "good";
    }
}
