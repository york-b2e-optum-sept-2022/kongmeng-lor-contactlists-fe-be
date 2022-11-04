package net.yorksolutions.fullstackappbackend.entity;
import javax.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    AccountEntity owner;

    private String name;
    private Integer phoneNumber;
    private String email;
    private String notes;

    public Contact() {}
    public Contact(AccountEntity owner, String name, Integer phoneNumber, String email, String notes) {
        this.owner = owner;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public AccountEntity getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwner(AccountEntity owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNote(String notes) {
        this.notes = notes;
    }

    public String getNote() {
        return notes;
    }
}
