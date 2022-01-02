package eu.filip.notes.controller;

import eu.filip.notes.model.RegistrationData;
import eu.filip.notes.model.User;
import eu.filip.notes.service.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


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
            User user = new User(
                    1L,
                    registrationData.getUsername(),
                    bCryptPasswordEncoder.encode(registrationData.getPassword()),
                    registrationData.getFirst_name(),
                    registrationData.getLast_name()
            );
            log.info(user.toString());
            userRepository.save(user);
        }
        return "redirect:/login";
    }
}
