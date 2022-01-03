package eu.filip.notes.service;

import eu.filip.notes.model.Note;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface NotesRepository extends CrudRepository<Note, Long> {
    @Query(value = "SELECT * FROM notes WHERE user_id = ?1", nativeQuery = true)
    ArrayList<Note> findByUserID(Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM notes WHERE id = ?1 AND user_id = ?2", nativeQuery = true)
    void deleteByIdAndUser_id(Long id, Long user_id);
}
