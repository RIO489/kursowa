package ISFTAOMAMPMA.service;


import ISFTAOMAMPMA.dto.OrderDTO;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public interface OrderService {
    OrderDTO create(OrderDTO dto) throws ServiceException;

    OrderDTO findOneById(Long id);

    OrderDTO update(OrderDTO dto)  throws ServiceException;

    void delete(Long id);

    List<OrderDTO> getAll();
}
