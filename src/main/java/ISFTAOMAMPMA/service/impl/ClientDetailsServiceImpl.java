package ISFTAOMAMPMA.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ISFTAOMAMPMA.entity.Client;
import ISFTAOMAMPMA.repository.ClientRepository;

@Service
public class ClientDetailsServiceImpl implements UserDetailsService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));

        return ClientDetailsImpl.build(client);
    }

}
