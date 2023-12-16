package ISFTAOMAMPMA.mapper;

import ISFTAOMAMPMA.dto.OrderDTO;
import ISFTAOMAMPMA.entity.Order;
import ISFTAOMAMPMA.repository.ClientRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperOrder {
    @Autowired
    private ClientRepository clientRepository;

    public OrderDTO toDto(final Order order) {
        final OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setAddress(order.getAddress());
        dto.setEmail(order.getCustomer().getEmail());
        dto.setOrderStatus(order.getOrderStatus());
        dto.setInfo(order.getInfo());
        return dto;

    }

    public Order toEntity(final OrderDTO dto) {
        final Order order = new Order();
        order.setId(dto.getId());
        order.setAddress(dto.getAddress());
        order.setCustomer(clientRepository.findByEmail(dto.getEmail()).orElseThrow(() -> new ServiceException("Can`t find User by this Email: " + dto.getEmail())));
        order.setOrderStatus(dto.getOrderStatus());
        order.setInfo(dto.getInfo());
        return order;
    }
}
