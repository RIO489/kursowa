package ISFTAOMAMPMA.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO extends UserDTO{
    @NotNull
    private String address;
    @NotNull
    private String phone;
}
