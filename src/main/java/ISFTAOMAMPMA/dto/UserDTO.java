package ISFTAOMAMPMA.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ISFTAOMAMPMA.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private UserRole userRole;
    @NotNull
    boolean userStatus;
}
