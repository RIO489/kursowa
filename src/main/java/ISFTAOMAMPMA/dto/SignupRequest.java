package ISFTAOMAMPMA.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ISFTAOMAMPMA.enums.UserRole;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
}