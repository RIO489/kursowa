package ISFTAOMAMPMA.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface ClientDetailsService {
    UserDetails loadUserByUsername(String username);
}
