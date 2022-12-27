package com.karen.KarenWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String getMain(){
        return "main";
    }
    @GetMapping("/game")
    public String getGame(){
        return "game";
    }
    @GetMapping("/users")
    public String getUsers(){
        return "users";
    }
    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }
    @GetMapping("/grass")
    public String getGrass(){
        return "grass";
    }
}
