package com.revature.SpringBootProjectTwo.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers",
        uniqueConstraints = @UniqueConstraint(
                name = "cust_email_unique",
                columnNames = "email"
        ))
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cust_id;               //Identifier for the customer
    private String cust_first_name;
    private String cust_last_name;
    @Column(
            name = "email",
            nullable = false
    )
    private String cust_email;
    private String cust_password;

    @OneToMany(targetEntity = Customer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "favorites")
    private List<Donut> favorites;
}
