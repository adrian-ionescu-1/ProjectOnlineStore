package org.example.services;

import org.example.dao.CustomeDao;
import org.example.entity.Order;
import org.example.entity.Product;
import org.example.entity.Role;
import org.example.entity.UserAccount;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class CustomDaoImpl implements CustomeDao {

    private final Session session;

    public CustomDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void addProduct(Product product) {
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();

            session.persist(product);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteProduct(Product product,Order order) {
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();

            product.setOrder(null);
            List<Product> products = order.getProductList();
            products.remove(product);

            session.delete(product);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void addUserAccount(UserAccount userAccount) {
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();

            session.persist(userAccount);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteUserAccount(UserAccount userAccount) {
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();

            session.delete(userAccount);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void addRole(Role role) {
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();

            session.persist(role);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Product getProduct(int id) {
        String findProductByIdQuery = "SELECT p from products p where p.id =: id";
        TypedQuery<Product> query = session.createQuery(findProductByIdQuery, Product.class);
        query.setParameter("id", id);

        List<Product> products = query.getResultList();
        if (!products.isEmpty()) {
            return products.get(0);
        } else {
            return null;
        }
    }

    @Override
    public UserAccount getUserAccount(int id) {
        String findUserAccountByIdQuery = "SELECT u from userAccounts u where u.id =: id";
        TypedQuery<UserAccount> query = session.createQuery(findUserAccountByIdQuery, UserAccount.class);
        query.setParameter("id", id);

        List<UserAccount> userAccounts = query.getResultList();
        if (!userAccounts.isEmpty()) {
            return userAccounts.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void addOrder(Order order) {
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();

            session.persist(order);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteOrder(Order order) {
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();

            session.delete(order);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteRole(Role role) {
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();

            session.delete(role);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
