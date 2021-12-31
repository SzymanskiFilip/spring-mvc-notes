package eu.filip.notes.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        log.info("/ - ENDPOINT HIT");
        model.addAttribute("text", "hello!");
        return "home";
    }
}
