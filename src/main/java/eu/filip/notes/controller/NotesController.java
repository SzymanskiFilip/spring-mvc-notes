package eu.filip.notes.controller;

import eu.filip.notes.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotesController {
    @GetMapping("/notes")
    public String notes(Model model){
        model.addAttribute("note", new Note(2,2, "My First  note!"));
        return "notes";
    }
}
