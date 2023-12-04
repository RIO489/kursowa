package ISFTAOMAMPMA.service.impl;

import ISFTAOMAMPMA.dto.AdminDTO;
import ISFTAOMAMPMA.entity.Administrator;
import ISFTAOMAMPMA.mapper.MapperAdministrator;
import ISFTAOMAMPMA.repository.AdminRepository;
import ISFTAOMAMPMA.service.AdminService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

    @Service
    @Transactional
    public class AdminServiceImpl implements AdminService {
        @Autowired
        private AdminRepository AdminRepository;

        @Autowired
        private MapperAdministrator mapperAdmin = new MapperAdministrator();

        @Override
        public AdminDTO create(AdminDTO dto) {
            Administrator admin = mapperAdmin.toEntity(dto);
            AdminRepository.save(admin);
            return mapperAdmin.toDto(admin);
        }

        @Override
        public AdminDTO read(Long id) {
            return mapperAdmin.toDto(AdminRepository.findById(id).orElseThrow());
        }

        @Override
        public void update(AdminDTO dto) {
            Administrator user = mapperAdmin.toEntity(dto);
            AdminRepository.save(user);
        }

        @Override
        public void delete(Long id) {
            AdminRepository.delete(AdminRepository.findById(id).orElseThrow());
        }
        @Override
        public List<AdminDTO> getAll() {
            return AdminRepository.findAll().stream().map(mapperAdmin::toDto).collect(Collectors.toList());
        }

}
