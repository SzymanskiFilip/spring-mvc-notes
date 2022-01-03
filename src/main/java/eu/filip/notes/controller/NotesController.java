package eu.filip.notes.controller;

import eu.filip.notes.model.Note;
import eu.filip.notes.service.NotesRepository;
import eu.filip.notes.service.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

    @Temporal(TemporalType.DATE)
    Date date;


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
        model.addAttribute("Note", new Note());
        return "add";
    }

    @PostMapping("/add")
    public String add(Note note){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long userID = userRepository.findByUsername(auth.getName()).getId();
        updateCurrentDate();


        Note toAdd = new Note();
        toAdd.setUser_id(userID);
        toAdd.setCreation_date(date);
        toAdd.setTitle(note.getTitle());
        toAdd.setContent(note.getContent());
        notesRepository.save(toAdd);

        return "redirect:/notes";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        notesRepository.deleteById(id);
        return "redirect:/notes";
    }


    private void updateCurrentDate(){
        this.date = new Date(System.currentTimeMillis());
    }
}
