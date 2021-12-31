package eu.filip.notes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    private int user_id;
    private int id;
    private String content;

    public Note(String content){
        this.content = content;
    }
}
