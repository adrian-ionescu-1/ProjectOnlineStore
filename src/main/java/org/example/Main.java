package org.example;

import org.example.entity.*;
import org.example.services.CustomDaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(UserAccount.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            Product product1 = new Product("Product1", "Description1", 10.1);
            Product product2 = new Product("Product2", "Description2", 20.5);
            Product product3 = new Product("Product3", "Description3", 9.5);

            CustomDaoImpl customDao = new CustomDaoImpl(session);

//            System.out.println(customDao.getProduct(1));

            List<Product> productList1 = List.of(product1);
            List<Product> productList2 = List.of(product2);
            List<Product> productList3 = List.of(product3);

            Address address1 = new Address("Romania", "Bucuresti", "Principala", 105784);
            Address address2 = new Address("Romania", "Cluj", "DumbravaRosie", 166684);
            Address address3 = new Address("Romania", "Iasi", "Eternitatii", 123456);

            Role role1 = new Role("ADMIN");
            Role role2 = new Role("USER");
            Role role3 = new Role("GUEST");

//            customDao.addRole(role1);
//            customDao.addRole(role2);
//            customDao.addRole(role3);

            List<Role> roles1 = List.of(role1);
            List<Role> roles2 = List.of(role2, role3);

            Order order1 = new Order("Marcel", 250.55, "Address1", LocalDate.now(), Status.PLACED);
            Order order2 = new Order("Alina", 100.20, "Address2", LocalDate.now(), Status.DELIVERED);
            Order order3 = new Order("Andrei", 50.99, "Address3", LocalDate.now(), Status.CONFIRMED);

            order1.addProduct(product1);
            order2.addProduct(product2);
            order3.addProduct(product3);

//            customDao.addProduct(product1);
//            customDao.addProduct(product2);
//            customDao.addProduct(product3);

            customDao.addOrder(order1);
            customDao.addOrder(order2);
            customDao.addOrder(order3);

//            order1.addAllProduct(productList1);
//            order2.addAllProduct(productList2);
//            order3.addAllProduct(List.of());

            List<Order> orderList1 = List.of(order1, order3);
            List<Order> orderList2 = List.of(order1, order2, order3);

            UserAccount userAccount1 = new UserAccount("Name1", "exemple1@email.com", "parola1", address1, roles1, orderList1);
            UserAccount userAccount2 = new UserAccount("Name2", "exemple2@email.com", "parola2", address2, roles2, orderList2);
            UserAccount userAccount3 = new UserAccount("Name3", "exemple3@email.com", "parola3", address3, List.of(), List.of());

            customDao.addUserAccount(userAccount1);
            customDao.addUserAccount(userAccount2);
            customDao.addUserAccount(userAccount3);

            customDao.deleteProduct(product1,order1);

//            customDao.deleteUserAccount(userAccount1);

//            System.out.println(customDao.getUserAccount(1));
        }
    }
}