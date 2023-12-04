package ISFTAOMAMPMA.mapper;

import ISFTAOMAMPMA.dto.ManagerDTO;
import ISFTAOMAMPMA.entity.Manager;
import org.springframework.stereotype.Component;

@Component
public class MapperManager {
    public ManagerDTO toDto(final Manager manager) {
        final ManagerDTO dto = new ManagerDTO();
        dto.setId(manager.getId());
        dto.setEmail(manager.getEmail());
        dto.setPassword(manager.getPassword());
        dto.setFirstName(manager.getFirstName());
        dto.setLastName(manager.getLastName());
        dto.setUserRole(manager.getUserRole());
        dto.setUserStatus(manager.isUserStatus());
        return dto;
    }

    public Manager toEntity(final ManagerDTO dto) {
        final Manager manager = new Manager();
        manager.setId(dto.getId());
        manager.setEmail(dto.getEmail());
        manager.setPassword(dto.getPassword());
        manager.setFirstName(dto.getFirstName());
        manager.setLastName(dto.getLastName());
        manager.setUserRole(dto.getUserRole());
        manager.setUserStatus(dto.isUserStatus());
        return manager;
    }
}
