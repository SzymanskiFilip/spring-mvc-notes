package eu.filip.notes.controller;

import eu.filip.notes.model.Note;
import eu.filip.notes.model.User;
import eu.filip.notes.service.NotesRepository;
import eu.filip.notes.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TestController {

    private NotesRepository notesRepository;
    private UserRepository userRepository;

    public TestController(NotesRepository notesRepository, UserRepository userRepository) {
        this.notesRepository = notesRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/testN")
    public ArrayList<Note> test(){
        return notesRepository.findAll();
    }

    @GetMapping("/testU")
    public ArrayList<User> users(){
        return userRepository.findAll();
    }
}
