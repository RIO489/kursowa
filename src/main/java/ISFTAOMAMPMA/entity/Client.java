package ISFTAOMAMPMA.entity;

import ISFTAOMAMPMA.annotations.ContactNumber;
import ISFTAOMAMPMA.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class Client extends User {
    @Column(name = "address")
    private String address;

    @ContactNumber
    @Column(name = "phone")
    private String phone;


    public Client(Long id, String email, String password, String first, String last, UserRole role, boolean b, String newaddress, String number) {
        // Client client = new Client();
        setId(id);
        setEmail(email);
        setPassword(password);
        setFirstName(first);
        setLastName(last);
        setUserRole(role);
        setUserStatus(b);
        address = newaddress;
        phone = number;
    }
}
