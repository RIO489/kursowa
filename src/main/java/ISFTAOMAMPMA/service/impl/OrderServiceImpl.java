package ISFTAOMAMPMA.service.impl;

import ISFTAOMAMPMA.dto.OrderDTO;
import ISFTAOMAMPMA.entity.Client;
import ISFTAOMAMPMA.entity.Order;
import ISFTAOMAMPMA.enums.OrderStatus;
import ISFTAOMAMPMA.mapper.MapperClient;
import ISFTAOMAMPMA.mapper.MapperOrder;
import ISFTAOMAMPMA.repository.ClientRepository;
import ISFTAOMAMPMA.repository.OrderRepository;
import ISFTAOMAMPMA.service.OrderService;
import jakarta.transaction.Transactional;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MapperOrder orderMapper;
    @Autowired
    private MapperClient mapperClient;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private MapperOrder mapperOrder;

    @Override
    public OrderDTO create(OrderDTO dto) throws ServiceException {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.PENDING);

       // Client client = clientRepository.findByEmail(dto.getCustomerEmail()).orElseThrow(() -> new ServiceException("Can`t find User by this Email: " + dto.getCustomerEmail()));
       order =  mapperOrder.toEntity(dto);

        //order.setCustomer(client);
        orderRepository.save(order);
        return orderMapper.toDto(order);
    }

    @Override
    public OrderDTO findOneById(Long id) {
        return orderMapper.toDto(orderRepository.findById(id).orElseThrow());
    }

    @Override
    public OrderDTO update(OrderDTO dto) throws ServiceException {
        Order oldOrder = orderRepository.findById(dto.getId()).stream().findFirst().orElseThrow();
        oldOrder.setAddress(dto.getAddress());
        if (!(oldOrder.getOrderStatus().name().equals("COMPLETED"))) {
            oldOrder.setOrderStatus(dto.getOrderStatus());
        }
        oldOrder.setOrderStatus(dto.getOrderStatus());
        Client client = clientRepository.findByEmail(dto.getEmail()).orElseThrow(() -> new ServiceException("Can`t find User by this ID: " + dto.getEmail()));
        oldOrder.setCustomer(client);

        orderRepository.save(oldOrder);
        return orderMapper.toDto(oldOrder);
    }

    @Override
    public void delete(Long id) {
        if(orderRepository.findById(id).isPresent()) {
            orderRepository.delete(orderRepository.findById(id).get());
        }
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(orderMapper::toDto).collect(Collectors.toList());
    }
}