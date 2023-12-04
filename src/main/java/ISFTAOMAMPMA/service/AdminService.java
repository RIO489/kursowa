package ISFTAOMAMPMA.service;

import ISFTAOMAMPMA.dto.AdminDTO;

import java.util.List;

public interface AdminService {
        AdminDTO create(AdminDTO dto);

        AdminDTO read(Long id);

        void update(AdminDTO dto);

        void delete(Long id);

        List<AdminDTO> getAll();
}
