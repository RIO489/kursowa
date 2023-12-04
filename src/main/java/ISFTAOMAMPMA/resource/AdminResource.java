package ISFTAOMAMPMA.resource;

import ISFTAOMAMPMA.dto.AdminDTO;
import ISFTAOMAMPMA.dto.ClientDTO;
import ISFTAOMAMPMA.repository.AdminRepository;
import ISFTAOMAMPMA.repository.ClientRepository;
import ISFTAOMAMPMA.service.AdminService;
import ISFTAOMAMPMA.service.ClientService;
import ISFTAOMAMPMA.service.impl.AdminServiceImpl;
import ISFTAOMAMPMA.service.impl.ClientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminResource {
    @Autowired
    private AdminService adminService = new AdminServiceImpl();
    @Autowired
    AdminRepository adminRepository;

    @PostMapping("/create")
    public String create(@Valid @RequestBody final AdminDTO adminDTO) {
        adminService.create(adminDTO);
        return "All good";
    }

    @GetMapping("/{id}")
    public AdminDTO read(final @PathVariable Long id) {
        return adminService.read(id);
    }

    @PutMapping("/update")
    public ResponseEntity<AdminDTO> update(@RequestBody AdminDTO AdminDTO) {
        adminService.update(AdminDTO);
        return ResponseEntity.ok(AdminDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(final @PathVariable("id") Long id) {
        AdminDTO AdminDTO = adminService.read(id);
        adminService.delete(id);
        return "User:" + AdminDTO.toString();
    }

    @GetMapping(value = "/all")
    public List<AdminDTO> getAll() {
        return adminService.getAll();
    }


}
