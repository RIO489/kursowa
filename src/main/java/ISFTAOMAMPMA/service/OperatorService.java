package ISFTAOMAMPMA.service;

import ISFTAOMAMPMA.dto.OperatorDTO;

import java.util.List;

public interface OperatorService {
        OperatorDTO create(OperatorDTO dto);

        OperatorDTO read(Long id);

        void update(OperatorDTO dto);

        void delete(Long id);

        List<OperatorDTO> getAll();
}

