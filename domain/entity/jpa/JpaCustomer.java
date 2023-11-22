package de.telran.g_280323_m_be_shop.domain.entity.jpa;

import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "customer")
public class JpaCustomer implements Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "name")
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be lank")
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Name must consist of at least 2 characters" +
            "and may not include any characters aside from Latin letters")
    private String name;

    @Column(name = "age")
    @Min(value = 12, message = "The minimum age eligible for registration is 12")
    @Positive
    private int age;

    @Column(name = "email")
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @OneToOne(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private JpaCart cart;

    public JpaCustomer() {

    }

    public JpaCustomer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public JpaCustomer(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JpaCart getCart() {
        return cart;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCart(JpaCart cart) {
        this.cart = cart;
    }
}
