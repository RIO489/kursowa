package ISFTAOMAMPMA.mapper;

import ISFTAOMAMPMA.dto.AdminDTO;
import ISFTAOMAMPMA.entity.Administrator;
import org.springframework.stereotype.Component;

@Component
public class MapperAdministrator {
    public AdminDTO toDto(final Administrator admin) {
        final AdminDTO dto = new AdminDTO();
        dto.setId(admin.getId());
        dto.setEmail(admin.getEmail());
        dto.setPassword(admin.getPassword());
        dto.setFirstName(admin.getFirstName());
        dto.setLastName(admin.getLastName());
        dto.setUserRole(admin.getUserRole());
        dto.setUserStatus(admin.isUserStatus());
        return dto;
    }

    public Administrator toEntity(final AdminDTO dto) {
        final Administrator admin = new Administrator();
        admin.setId(dto.getId());
        admin.setEmail(dto.getEmail());
        admin.setPassword(dto.getPassword());
        admin.setFirstName(dto.getFirstName());
        admin.setLastName(dto.getLastName());
        admin.setUserRole(dto.getUserRole());
        admin.setUserStatus(dto.isUserStatus());
        return admin;
    }
}
