package tobyspring.hellospring.data;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.simple.JdbcClient;
import tobyspring.hellospring.order.Order;
import tobyspring.hellospring.order.OrderRepository;

import javax.sql.DataSource;

public class JdbcOrderRepository implements OrderRepository {
    private final JdbcClient jdbcClient;

    public JdbcOrderRepository(DataSource dataSource) {
        this.jdbcClient = JdbcClient.create(dataSource);
    }

    @PostConstruct
    void initDb() {
        jdbcClient.sql("""
            create table orders (id bigint not null, no varchar(255), total numeric(38,2), primary key (id));
            alter table if exists orders drop constraint if exists UK_43egxxciqr9ncgmxbdx2avi8n;
            alter table if exists orders add constraint UK_43egxxciqr9ncgmxbdx2avi8n unique (no);
            create sequence orders_SEQ start with 1 increment by 50;
        """).update();
    }

    @Override
    public void save(Order order) {
        Long id = jdbcClient.sql("select next value for orders_SEQ").query(Long.class).single();
        order.setId(id);

        jdbcClient.sql("insert into orders (no,total,id) values (?,?,?)")
                .params(order.getNo(), order.getTotal(), order.getId())
                .update();
    }
}
