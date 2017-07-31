package gmail.alexdudarkov.sportshop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable{

    private static final long serialVersionUID = 3342734444265715939L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long Id;
    @ManyToOne(optional = false)
    @JoinColumn(name="good_id", nullable = false)
    private Good good;
    @Column(name = "count")
    private Integer count;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;

        OrderItem orderItem = (OrderItem) o;

        if (Id != null ? !Id.equals(orderItem.Id) : orderItem.Id != null) return false;
        return count != null ? count.equals(orderItem.count) : orderItem.count == null;
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "Id=" + Id +
                ", good=" + good +
                ", count=" + count +
                '}';
    }
}
