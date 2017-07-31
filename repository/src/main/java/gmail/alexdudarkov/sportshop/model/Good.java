package gmail.alexdudarkov.sportshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
@Entity
@Table(name = "goods")
public class Good implements Serializable {

    private static final long serialVersionUID = -5810065937160014674L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "good_id")
    private Long id;
    @Column(name = "model")
    private String model;
    @Column (name = "price", precision = 8, scale = 2)
    private BigDecimal price;
    @Column(name = "icon_path")
    private String iconPath;
    @Column(name = "availability")
    private Boolean availability;
    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_good_id", nullable = false)
    private BrandGood brandGood;
    @ManyToOne(optional = false)
    @JoinColumn(name="type_good_id", nullable = false)
    private TypeGood typeGood;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public BrandGood getBrandGood() {
        return brandGood;
    }

    public void setBrandGood(BrandGood brandGood) {
        this.brandGood = brandGood;
    }

    public TypeGood getTypeGood() {
        return typeGood;
    }

    public void setTypeGood(TypeGood typeGood) {
        this.typeGood = typeGood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Good)) return false;

        Good good = (Good) o;

        if (id != null ? !id.equals(good.id) : good.id != null) return false;
        return model != null ? model.equals(good.model) : good.model == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Good{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", iconPath='" + iconPath + '\'' +
                ", availability=" + availability +
                ", brandGood=" + brandGood +
                ", typeGood=" + typeGood +
                '}';
    }
}
