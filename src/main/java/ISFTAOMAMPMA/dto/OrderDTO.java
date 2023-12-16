package ISFTAOMAMPMA.dto;


import ISFTAOMAMPMA.enums.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    @NotNull
    private String email;
    @NotNull
    private OrderStatus orderStatus;
    @NotNull
    private String address;
    @NotNull
    private String info;
}
