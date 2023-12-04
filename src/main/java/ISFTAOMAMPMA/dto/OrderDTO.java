package ISFTAOMAMPMA.dto;


import ISFTAOMAMPMA.enums.OrderStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    @NotNull
    private String customerEmail;
    @NotNull
    private OrderStatus orderStatus;
    @NotNull
    private String address;
    @NotNull
    private String info;
}
