package kz.narxoz.springapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")

public class Controller {
    @GetMapping("/a")
    public String hi(){
        return "narxoz university";
    }
    @GetMapping("/b")
    public String bye(){
        return "almaty ! ! !";
    }
}