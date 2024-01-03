package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable

public class Address {

    private String country;
    private String city;
    private String street;
    private Integer zipCode;
}
