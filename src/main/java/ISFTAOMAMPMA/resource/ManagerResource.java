package ISFTAOMAMPMA.resource;

import ISFTAOMAMPMA.dto.ClientDTO;
import ISFTAOMAMPMA.dto.ManagerDTO;
import ISFTAOMAMPMA.repository.ManagerRepository;
import ISFTAOMAMPMA.service.ManagerService;
import ISFTAOMAMPMA.service.impl.ManagerServcieImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerResource {
    @Autowired
    private ManagerService managerService = new ManagerServcieImpl();
    @Autowired
    ManagerRepository ManagerRepository;

    @PostMapping("/create")
    public String create(@Valid @RequestBody final ManagerDTO ManagerDTO) {
        managerService.create(ManagerDTO);
        return "All good";
    }

    @GetMapping("/{id}")
    public ManagerDTO read(final @PathVariable Long id) {
        return managerService.read(id);
    }

    @PutMapping("/update")
    public ResponseEntity<ManagerDTO> update(@RequestBody ManagerDTO ManagerDTO) {
        managerService.update(ManagerDTO);
        return ResponseEntity.ok(ManagerDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(final @PathVariable("id") Long id) {
        ManagerDTO ManagerDTO = managerService.read(id);
        managerService.delete(id);
        return "User:" + ManagerDTO.toString();
    }

    @GetMapping(value = "/all")
    public List<ManagerDTO> getAll() {
        return managerService.getAll();
    }


}

