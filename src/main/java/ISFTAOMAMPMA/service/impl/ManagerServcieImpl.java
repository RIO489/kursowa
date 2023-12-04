package ISFTAOMAMPMA.service.impl;

import ISFTAOMAMPMA.dto.ManagerDTO;
import ISFTAOMAMPMA.entity.Manager;
import ISFTAOMAMPMA.mapper.MapperManager;
import ISFTAOMAMPMA.repository.ManagerRepository;
import ISFTAOMAMPMA.service.ManagerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

    @Service
    @Transactional
    public class ManagerServcieImpl implements ManagerService {
        @Autowired
        private ManagerRepository ManagerRepository;

        @Autowired
        private MapperManager mapperManager = new MapperManager();

        @Override
        public ManagerDTO create(ManagerDTO dto) {
            Manager Manager = mapperManager.toEntity(dto);
            ManagerRepository.save(Manager);
            return mapperManager.toDto(Manager);
        }

        @Override
        public ManagerDTO read(Long id) {
            return mapperManager.toDto(ManagerRepository.findById(id).orElseThrow());
        }

        @Override
        public void update(ManagerDTO dto) {
            Manager user = mapperManager.toEntity(dto);
            ManagerRepository.save(user);
        }

        @Override
        public void delete(Long id) {
            ManagerRepository.delete(ManagerRepository.findById(id).orElseThrow());
        }
        @Override
        public List<ManagerDTO> getAll() {
            return ManagerRepository.findAll().stream().map(mapperManager::toDto).collect(Collectors.toList());
        }
    }
