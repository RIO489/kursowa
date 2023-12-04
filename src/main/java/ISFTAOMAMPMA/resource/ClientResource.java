package ISFTAOMAMPMA.resource;

import ISFTAOMAMPMA.dto.ClientDTO;
import ISFTAOMAMPMA.dto.OrderDTO;
import ISFTAOMAMPMA.repository.OrderRepository;
import ISFTAOMAMPMA.service.OrderService;
import ISFTAOMAMPMA.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ISFTAOMAMPMA.repository.ClientRepository;
import ISFTAOMAMPMA.service.ClientService;
import ISFTAOMAMPMA.service.impl.ClientServiceImpl;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientResource {
    @Autowired
    private ClientService clientService = new ClientServiceImpl();
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private OrderService orderService = new OrderServiceImpl();
    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/create")
    public String create(@Valid @RequestBody final ClientDTO clientDTO) {
        clientService.create(clientDTO);
        return "All good";
    }
    @GetMapping("/{id}")
    public ClientDTO read(final @PathVariable Long id) {
        return clientService.read(id);
    }

    @PutMapping("/update")
    public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO clientDTO) {
        clientService.update(clientDTO);
        return ResponseEntity.ok(clientDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(final @PathVariable("id") Long id) {
        ClientDTO clientDTO = clientService.read(id);
        clientService.delete(id);
        return "User:" + clientDTO.toString();
    }

    @GetMapping(value = "/all")
    public List<ClientDTO> getAll() {
        return clientService.getAll();
    }

    @PostMapping("/order")
    public String makeOrder(@Valid @RequestBody final OrderDTO orderDTO){
        orderService.create(orderDTO);
        return "Order is registered";
    }
}
