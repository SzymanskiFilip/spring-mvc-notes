package eu.filip.notes.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LoginController {
    @GetMapping("/login")
    public String login(){
        log.info("/login - ENDPOINT HIT");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "home";
    }
}
