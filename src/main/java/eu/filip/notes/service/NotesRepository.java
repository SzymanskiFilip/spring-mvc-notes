package eu.filip.notes.service;

import eu.filip.notes.model.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface NotesRepository extends CrudRepository<Note, Long> {
    ArrayList<Note> findAll();

    @Query(value = "SELECT * FROM notes WHERE user_id = ?1", nativeQuery = true)
    ArrayList<Note> findByUserID(Long id);
    void deleteById(Long id);
}
