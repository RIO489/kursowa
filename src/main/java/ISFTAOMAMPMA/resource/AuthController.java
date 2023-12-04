package ISFTAOMAMPMA.resource;


import ISFTAOMAMPMA.dto.JwtResponse;
import ISFTAOMAMPMA.dto.LoginRequest;
import ISFTAOMAMPMA.dto.MessageResponse;
import ISFTAOMAMPMA.dto.SignupRequest;
import ISFTAOMAMPMA.entity.Client;
import ISFTAOMAMPMA.repository.ClientRepository;
import ISFTAOMAMPMA.security.JwtUtils;
import ISFTAOMAMPMA.service.impl.ClientDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        ClientDetailsImpl clientDetails = (ClientDetailsImpl) authentication.getPrincipal();
        String roles = clientDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .findAny().get();

        return ResponseEntity.ok(new JwtResponse(jwt,
                clientDetails.getId(),
                clientDetails.getUsername(),
                clientDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (clientRepository.existsByEmail(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (clientRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new client's account
        Client client = new Client(null, signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()), "", "",null
                ,true,"","");

        client.setUserRole(signUpRequest.getRole());
        clientRepository.save(client);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
