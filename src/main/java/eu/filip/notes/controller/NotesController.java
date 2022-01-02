package eu.filip.notes.controller;

import eu.filip.notes.model.Note;
import eu.filip.notes.service.NotesRepository;
import eu.filip.notes.service.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.util.ArrayList;

@Controller
@Slf4j
public class NotesController {

    UserRepository userRepository;
    NotesRepository notesRepository;


    public NotesController(UserRepository ur, NotesRepository nr){
        this.userRepository = ur;
        this.notesRepository = nr;
    }


    @GetMapping("/notes")
    public String notes(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long userID = userRepository.findByUsername(auth.getName()).getId();
        ArrayList<Note> notes = notesRepository.findByUserID(userID);
        model.addAttribute("notes", notes);
        return "notes";
    }

    @GetMapping("/add")
    public String add(Model model){
        log.info("/add - ENDPOINT HIT");
        model.addAttribute("note", new Note());
        return "add";
    }

    @PostMapping("/add")
    public String add(Note note){
        log.info("added new note:" + note.toString());
        return "home";
    }
}
