package ISFTAOMAMPMA.service.impl;

import ISFTAOMAMPMA.dto.ClientDTO;
import ISFTAOMAMPMA.dto.UserDTO;
import ISFTAOMAMPMA.entity.Client;
import ISFTAOMAMPMA.entity.User;
import ISFTAOMAMPMA.mapper.MapperClient;
import ISFTAOMAMPMA.repository.ClientRepository;
import ISFTAOMAMPMA.service.ClientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
    @Transactional
    public class ClientServiceImpl implements ClientService {
        @Autowired
        private ClientRepository clientRepository;

        @Autowired
        private MapperClient mapperClient = new MapperClient();

        @Override
        public ClientDTO create(ClientDTO dto) {
            Client user = mapperClient.toEntity(dto);
            clientRepository.save(user);
            return mapperClient.toDto(user);
        }

        @Override
        public ClientDTO read(Long id) {
            return mapperClient.toDto(clientRepository.findById(id).orElseThrow());
        }

        @Override
        public void update(ClientDTO dto) {
            Client user = mapperClient.toEntity(dto);
            clientRepository.save(user);
        }

        @Override
        public void delete(Long id) {
            clientRepository.delete(clientRepository.findById(id).orElseThrow());
        }
        @Override
        public List<ClientDTO> getAll() {
            return clientRepository.findAll().stream().map(mapperClient::toDto).collect(Collectors.toList());
        }

}
