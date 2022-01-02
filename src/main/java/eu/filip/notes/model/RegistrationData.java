package eu.filip.notes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationData {

    @NotBlank(message = "required")
    private String username;

    @NotBlank(message = "required")
    @Length(min = 6, message = "Passwords have to be at least 6 characters long")
    private String password;

    @NotBlank(message = "required")
    private String password_confirmation;

    @NotBlank(message = "required")
    private String first_name;

    @NotBlank(message = "required")
    private String last_name;

    private boolean passwordsDontMatch;


    public void checkPasswords(){
        if(password.equals(password_confirmation)){
            passwordsDontMatch = false;
        }else{
            passwordsDontMatch = true;
        }
    }
}
