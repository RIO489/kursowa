package ISFTAOMAMPMA.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@Table(name = "user")
public class Administrator extends User{
}
