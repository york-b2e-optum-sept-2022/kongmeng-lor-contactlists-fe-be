package net.yorksolutions.fullstackappbackend.entity;
import javax.persistence.*;

@Entity
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(unique = true)//Having a unique email only
    String email;
    String password;
    String fristName;
    String lastName;

    public AccountEntity() {}

    public AccountEntity(String email, String password, String fristName, String lastName) {
        this.email = email;
        this.password = password;
        this.fristName = fristName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public Long getId() {
        return id;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
