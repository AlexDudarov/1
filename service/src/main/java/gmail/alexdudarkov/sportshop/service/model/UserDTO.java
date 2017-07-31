package gmail.alexdudarkov.sportshop.service.model;

import gmail.alexdudarkov.sportshop.model.Gender;
import gmail.alexdudarkov.sportshop.model.Role;
import gmail.alexdudarkov.sportshop.model.User;

/**
 * Created by User-PC on 23.07.2017.
 */
public class UserDTO {
    private Long id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private Gender gender;
    private Role role;

    public UserDTO(User user) {
        this(
                newBuilder()
                        .id(user.getId())
                        .login(user.getLogin())
                        .password(user.getPassword())
                        .name(user.getUserInformation().getName())
                        .surname(user.getUserInformation().getSurname())
                        .role(user.getRole())
                        .gender(user.getUserInformation().getGender())
        );
    }

    private UserDTO(Builder builder) {
        setId(builder.id);
        setLogin(builder.login);
        setPassword(builder.password);
        setName(builder.name);
        setRole(builder.role);
        setSurname(builder.surname);
        setGender(builder.gender);

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static final class Builder {

        private Long id;
        private String login;
        private String password;
        private String name;
        private Role role;
        private String surname;
        private Gender gender;

        private Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder login(String val) {
            login = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder role(Role val) {
            role = val;
            return this;
        }

        public Builder gender(Gender val) {
            gender = val;
            return this;
        }

        public Builder surname(String val) {
            surname = val;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", role=" + role +
                '}';
    }
}
