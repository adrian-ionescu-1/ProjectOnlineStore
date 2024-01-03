package org.example.dao;

import org.example.entity.Order;
import org.example.entity.Product;
import org.example.entity.Role;
import org.example.entity.UserAccount;

import java.util.List;

public interface CustomeDao {
    public void addProduct(Product product);
    public void deleteProduct(Product product,Order order);
    public void addUserAccount(UserAccount userAccount);
    public void deleteUserAccount(UserAccount userAccount);
    public void addRole(Role role);
    public Product getProduct(int id);
    public UserAccount getUserAccount(int id);
    public void addOrder(Order order);
    public void deleteOrder(Order order);
    public void deleteRole(Role role);

}
