package eu.filip.notes.controller;

import eu.filip.notes.model.RegistrationData;
import eu.filip.notes.service.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
public class RegisterController {

    UserRepository userRepository;

    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @GetMapping("/register")
    public String register(@ModelAttribute RegistrationData registrationData, Model model){
        model.addAttribute("registrationData", registrationData);
        return "register";
    }

    @PostMapping("/register")
    public String save(@Valid RegistrationData registrationData, BindingResult bindingResult){
        registrationData.checkPasswords();
        log.info(registrationData.toString());
        if(bindingResult.hasErrors() || registrationData.isPasswordsDontMatch()){
            return "register";
        } else {
            
        }
        return "redirect:/login";
    }
}
