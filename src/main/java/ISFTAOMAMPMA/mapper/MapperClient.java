package ISFTAOMAMPMA.mapper;

import ISFTAOMAMPMA.dto.ClientDTO;
import ISFTAOMAMPMA.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class MapperClient {
    public ClientDTO toDto(final Client client) {
        final ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setEmail(client.getEmail());
        dto.setPassword(client.getPassword());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setUserRole(client.getUserRole());
        dto.setUserStatus(client.isUserStatus());
        return dto;
    }

    public Client toEntity(final ClientDTO dto) {
        final Client client = new Client();
        client.setId(dto.getId());
        client.setEmail(dto.getEmail());
        client.setPassword(dto.getPassword());
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        client.setUserRole(dto.getUserRole());
        client.setUserStatus(dto.isUserStatus());
        return client;
    }
}
