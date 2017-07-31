package gmail.alexdudarkov.sportshop.service.model;


import gmail.alexdudarkov.sportshop.model.Good;
import gmail.alexdudarkov.sportshop.service.BrandGoodServiceImpl;

import java.math.BigDecimal;

public class GoodDTO {
    private Long id;
    private String model;
    private BigDecimal price;
    private String iconPath;
    private Boolean availability;
    private BrandGoodDTO brandGoodDto;
    private TypeGoodDTO typeGoodDto;

    public GoodDTO(Good good) {
        this(
                newBuilder()
                        .id(good.getId())
                        .model(good.getModel())
                        .availability(good.getAvailability())
                        .iconPath(good.getIconPath())
                        .price(good.getPrice())
                        .brandGoodDto(new BrandGoodDTO(good.getBrandGood()))
                        .typeGoodDto(new TypeGoodDTO(good.getTypeGood()))
        );
    }
    private GoodDTO(Builder builder) {
        setId(builder.id);
        setAvailability(builder.availability);
        setIconPath(builder.iconPath);
        setModel(builder.model);
        setPrice(builder.price);
        setBrandGoodDto(builder.brandGoodDto);
        setTypeGoodDto(builder.typeGoodDto);
    }
    public static Builder newBuilder() {
        return new Builder();
    }

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

    public BrandGoodDTO getBrandGoodDto() {
        return brandGoodDto;
    }

    public void setBrandGoodDto(BrandGoodDTO brandGoodDto) {
        this.brandGoodDto = brandGoodDto;
    }

    public TypeGoodDTO getTypeGoodDto() {
        return typeGoodDto;
    }

    public void setTypeGoodDto(TypeGoodDTO typeGoodDto) {
        this.typeGoodDto = typeGoodDto;
    }
    public static final class Builder {
        private Long id;
        private String model;
        private BigDecimal price;
        private String iconPath;
        private Boolean availability;
        private BrandGoodDTO brandGoodDto;
        private TypeGoodDTO typeGoodDto;

        private Builder() {}

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder model(String val) {
            model = val;
            return this;
        }

        public Builder price(BigDecimal val) {
            price = val;
            return this;
        }

        public Builder iconPath(String val) {
            iconPath = val;
            return this;
        }

        public Builder availability(Boolean val) {
            availability = val;
            return this;
        }

        public Builder brandGoodDto(BrandGoodDTO val) {
            brandGoodDto = val;
            return this;
        }

        public Builder typeGoodDto(TypeGoodDTO val) {
            typeGoodDto = val;
            return this;
        }

        public GoodDTO build() {
            return new GoodDTO(this);
        }

    }
}
