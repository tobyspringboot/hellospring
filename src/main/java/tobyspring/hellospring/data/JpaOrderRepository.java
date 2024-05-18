package tobyspring.hellospring.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import tobyspring.hellospring.order.Order;
import tobyspring.hellospring.order.OrderRepository;

public class JpaOrderRepository implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }
}
