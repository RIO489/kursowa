package ISFTAOMAMPMA.service;

import ISFTAOMAMPMA.dto.ClientDTO;
import ISFTAOMAMPMA.dto.UserDTO;

import java.util.List;

public interface ClientService {
    ClientDTO create(ClientDTO dto);

    ClientDTO read(Long id);

    void update(ClientDTO dto);

    void delete(Long id);

    List<ClientDTO> getAll();
}
