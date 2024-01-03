package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private double totalCost;
    private String deliveryAddress;
    private LocalDate dateOfSubmission;
    private Status status;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        this.productList.add(product);
        product.setOrder(this);
    }

    public void addAllProduct(List<Product> productList) {
        this.productList.addAll(productList);
        productList.forEach(product -> product.setOrder(this));
    }

    public void removeProduct(Product product) {
        this.productList.remove(product);
        product.setOrder(null);
    }

    public Order(String userName, double totalCost, String deliveryAddress, LocalDate dateOfSubmission, Status status) {
        this.userName = userName;
        this.totalCost = totalCost;
        this.deliveryAddress = deliveryAddress;
        this.dateOfSubmission = dateOfSubmission;
        this.status = status;
    }
}
