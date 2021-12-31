package eu.filip.notes.controller;

import eu.filip.notes.model.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class NotesController {
    @GetMapping("/notes")
    public String notes(Model model){
        log.info("/ - ENDPOINT HIT");
        model.addAttribute("note", new Note(2L,2L, "My First  note!"));
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
