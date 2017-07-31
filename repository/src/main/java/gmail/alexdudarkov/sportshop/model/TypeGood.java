package gmail.alexdudarkov.sportshop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="type_good")
public class  TypeGood implements Serializable{
    private static final long serialVersionUID = 4169236158826948551L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_good_id")
    private Long id;
    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeGood)) return false;

        TypeGood typeGood = (TypeGood) o;

        if (id != null ? !id.equals(typeGood.id) : typeGood.id != null) return false;
        return name != null ? name.equals(typeGood.name) : typeGood.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TypeGood{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
