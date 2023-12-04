package ISFTAOMAMPMA.mapper;

import ISFTAOMAMPMA.dto.AdminDTO;
import ISFTAOMAMPMA.dto.OperatorDTO;
import ISFTAOMAMPMA.entity.Administrator;
import ISFTAOMAMPMA.entity.Operator;
import org.springframework.stereotype.Component;

@Component
public class MapperOperator {
    public OperatorDTO toDto(final Operator operator) {
        final OperatorDTO dto = new OperatorDTO();
        dto.setId(operator.getId());
        dto.setEmail(operator.getEmail());
        dto.setPassword(operator.getPassword());
        dto.setFirstName(operator.getFirstName());
        dto.setLastName(operator.getLastName());
        dto.setUserRole(operator.getUserRole());
        dto.setUserStatus(operator.isUserStatus());
        return dto;
    }

    public Operator toEntity(final OperatorDTO dto) {
        final Operator operator = new Operator();
        operator.setId(dto.getId());
        operator.setEmail(dto.getEmail());
        operator.setPassword(dto.getPassword());
        operator.setFirstName(dto.getFirstName());
        operator.setLastName(dto.getLastName());
        operator.setUserRole(dto.getUserRole());
        operator.setUserStatus(dto.isUserStatus());
        return operator;
    }
}
