package ISFTAOMAMPMA.resource;

import ISFTAOMAMPMA.dto.OrderDTO;
import ISFTAOMAMPMA.service.OrderService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderResource {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderDTO create(final @RequestBody OrderDTO orderDTO) throws ServiceException {
        return orderService.create(orderDTO);
    }

    @PutMapping
    public OrderDTO put(final @RequestBody OrderDTO orderDTO) throws ServiceException {
        return orderService.update(orderDTO);
    }

    @GetMapping("/{id}")
    public OrderDTO get(final @PathVariable Long id) {
        return orderService.findOneById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(final @PathVariable Long id) {
        orderService.delete(id);
    }
}
