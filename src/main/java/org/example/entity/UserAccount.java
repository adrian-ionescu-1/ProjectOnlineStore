package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "userAccounts")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    @Embedded
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "User_Role",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private List<Role> roles = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "User_Order",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "order_id") }
    )
    private List<Order> orders = new ArrayList<>();

    public UserAccount(String name, String email, String password, Address address, List<Role> roles, List<Order> orders) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.roles = roles;
        this.orders = orders;
    }
}
