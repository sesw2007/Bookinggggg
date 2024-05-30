package org.example.springboot.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springboot.enums.Country;


import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "username")
    private String username;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "city")
    private String city;
    @Enumerated(EnumType.STRING)
    private Country country;
    @Column(name = "nick")
    private String nick;
    @Column(name = "password")
    private String password;
    @Column(name = "user_date")
    private LocalDate userdate;
    @Column(name = "email")
    private String email;
    @JoinTable(name = "user_role_relation",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles;
}
