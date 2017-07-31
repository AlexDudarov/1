package gmail.alexdudarkov.sportshop.service.model;

import gmail.alexdudarkov.sportshop.model.TypeGood;


public class TypeGoodDTO {
    private Long id;
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

    public TypeGoodDTO(TypeGood typeGood) {
        this(
                newBuilder()
                        .id(typeGood.getId())
                        .name(typeGood.getName())
        );
    }
    private TypeGoodDTO(Builder builder) {
        setId(builder.id);
        setName(builder.name);
    }
    public static Builder newBuilder() {
        return new Builder();
    }
    public static final class Builder {
        private Long id;
        private String name;







        private Builder(){}

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder name(String val){
            name=val;
            return this;
        }

        public TypeGoodDTO build() {
            return new TypeGoodDTO(this);
        }
    }

    @Override
    public String toString() {
        return "TypeGoodDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
