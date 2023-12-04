package ISFTAOMAMPMA.service;

import ISFTAOMAMPMA.dto.ManagerDTO;

import java.util.List;

public interface ManagerService {
        ManagerDTO create(ManagerDTO dto);

        ManagerDTO read(Long id);

        void update(ManagerDTO dto);

        void delete(Long id);

        List<ManagerDTO> getAll();

}
