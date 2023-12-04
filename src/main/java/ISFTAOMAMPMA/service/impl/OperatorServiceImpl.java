package ISFTAOMAMPMA.service.impl;

import ISFTAOMAMPMA.dto.OperatorDTO;
import ISFTAOMAMPMA.entity.Operator;
import ISFTAOMAMPMA.mapper.MapperOperator;
import ISFTAOMAMPMA.repository.OperatorRepository;
import ISFTAOMAMPMA.service.OperatorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

    @Service
    @Transactional
    public class OperatorServiceImpl implements OperatorService {
        @Autowired
        private OperatorRepository OperatorRepository;

        @Autowired
        private MapperOperator mapperOperator = new MapperOperator();

        @Override
        public OperatorDTO create(OperatorDTO dto) {
            Operator Operator = mapperOperator.toEntity(dto);
            OperatorRepository.save(Operator);
            return mapperOperator.toDto(Operator);
        }

        @Override
        public OperatorDTO read(Long id) {
            return mapperOperator.toDto(OperatorRepository.findById(id).orElseThrow());
        }

        @Override
        public void update(OperatorDTO dto) {
            Operator user = mapperOperator.toEntity(dto);
            OperatorRepository.save(user);
        }

        @Override
        public void delete(Long id) {
            OperatorRepository.delete(OperatorRepository.findById(id).orElseThrow());
        }

        @Override
        public List<OperatorDTO> getAll() {
            return OperatorRepository.findAll().stream().map(mapperOperator::toDto).collect(Collectors.toList());
        }
    }