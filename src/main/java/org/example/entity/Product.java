package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "order")
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Product(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

}
