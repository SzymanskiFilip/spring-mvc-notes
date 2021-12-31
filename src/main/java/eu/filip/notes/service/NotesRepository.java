package eu.filip.notes.service;

import eu.filip.notes.model.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface NotesRepository extends CrudRepository<Note, Long> {
    ArrayList<Note> findAll();
}
