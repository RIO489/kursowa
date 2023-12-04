package ISFTAOMAMPMA.security;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Set;

import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import ISFTAOMAMPMA.service.impl.ClientDetailsImpl;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Component
@Slf4j
public class JwtUtils {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs;


    public String generateJwtToken(Authentication authentication) {
        ClientDetailsImpl userPrincipal = (ClientDetailsImpl) authentication.getPrincipal();

        // Convert jwtSecret to Key
        Key signingKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        // Use signWith method with Key
        JwtBuilder jwtBuilder = Jwts.builder()
                .claim("sub", userPrincipal.getUsername())
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(signingKey);

        // Compact the JWT and return
        return jwtBuilder.compact();
    }

   // public String getUserNameFromJwtToken(String token) {
   //     JwtParser jwtParser = Jwts.parser().verifyWith(jwtSecret).build();
   //     Jws<Claims> jws = jwtParser.parseSignedClaims(token);
   //     return jws.getBody().getSubject();
   // }

    public String getUserNameFromJwtToken(String token) {
        byte[] secretKeyBytes = jwtSecret.getBytes();

        SecretKey secretKey = new SecretKeySpec(secretKeyBytes, "HmacSHA256");

        JwtParserBuilder jwtParserBuilder = Jwts.parser().verifyWith(secretKey);
        Jws<Claims> jws = jwtParserBuilder.build().parseSignedClaims(token);
        Claims claims =  jws.getPayload();
        //Claims claims = jws.getBody();
        return claims.get("email", String.class);
    }

    public boolean validateJwtToken(String authToken) {
        try {
            byte[] secretKeyBytes = jwtSecret.getBytes();

            // Example of generating a key one time
           // KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            // keyGenerator.init(256); // Initialize to generate 256-bit keys
           // SecretKey key = keyGenerator.generateKey();
            //byte[] secretKeyBytes = key.getEncoded();
            //byte[] secretKeyBytes = {-28, -122, 64, 25, -114, 99, -25, -51, 103, 39, -13, 1, -114, -54, 19, 85, 94, 60, -122, -18, -100, 56, -118, 56, 111, 60, -52, -105, -54, -51, 62, 91};

            SecretKey secretKey = new SecretKeySpec(secretKeyBytes, "HmacSHA256");
            Jws<Claims> jws = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}