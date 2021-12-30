package eu.filip.notes.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Note {
    private int user_id;
    private int id;
    private String content;

    public Note(int user_id, int id, String content){
        this.user_id = user_id;
        this.id = id;
        this.content = content;
    }
}
