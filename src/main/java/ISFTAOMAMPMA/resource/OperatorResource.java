package ISFTAOMAMPMA.resource;

import ISFTAOMAMPMA.dto.OperatorDTO;
import ISFTAOMAMPMA.repository.OperatorRepository;
import ISFTAOMAMPMA.service.OperatorService;
import ISFTAOMAMPMA.service.impl.OperatorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operator")
public class OperatorResource {
    @Autowired
    private OperatorService operatorService = new OperatorServiceImpl();
    @Autowired
    OperatorRepository operatorRepository;

    @PostMapping("/create")
    public String create(@Valid @RequestBody final OperatorDTO operatorDTO) {
        operatorService.create(operatorDTO);
        return "All good";
    }

    @GetMapping("/{id}")
    public OperatorDTO read(final @PathVariable Long id) {
        return operatorService.read(id);
    }

    @PutMapping("/update")
    public ResponseEntity<OperatorDTO> update(@RequestBody OperatorDTO operatorDTO) {
        operatorService.update(operatorDTO);
        return ResponseEntity.ok(operatorDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(final @PathVariable("id") Long id) {
        OperatorDTO operatorDTO = operatorService.read(id);
        operatorService.delete(id);
        return "User:" + operatorDTO.toString();
    }

    @GetMapping(value = "/all")
    public List<OperatorDTO> getAll() {
        return operatorService.getAll();
    }


}

