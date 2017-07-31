package gmail.alexdudarkov.sportshop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "brand_good")
public class BrandGood implements Serializable{
    private static final long serialVersionUID = 3363444011562536358L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_good_id")
    private Long id;

    @Column(name ="name")
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
        if (!(o instanceof BrandGood)) return false;

        BrandGood brand = (BrandGood) o;

        if (id != null ? !id.equals(brand.id) : brand.id != null) return false;
        return name != null ? name.equals(brand.name) : brand.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BrandGood{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
