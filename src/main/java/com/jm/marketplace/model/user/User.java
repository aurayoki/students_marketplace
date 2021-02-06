package com.jm.marketplace.model.user;

import com.jm.marketplace.model.Advertisement;
import com.jm.marketplace.model.City;
import com.jm.marketplace.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class
User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", length = 30)
    @NotBlank
    private String firstName;

    @Column(name = "last_name", length = 30)
    @NotBlank
    private String lastName;

    @Column(name = "password", nullable = false)
    @NotBlank
    private String password;

    @Column(name = "email", unique = true)
    @NotBlank
    private String email;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @NotNull
    private City city;

    @Column(name = "date")
    @NotBlank
    private LocalDate date;

    @Column(name = "phone", unique = true)
    @NotBlank
    private String phone;

    @Column(name = "user_img")
    private String userImg;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy="users")
    private Set<Advertisement> advertisements;

    public User(String firstName, String lastName, String password, String email, City city, LocalDate date, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.city = city;
        this.date = date;
        this.phone = phone;
    }
}
