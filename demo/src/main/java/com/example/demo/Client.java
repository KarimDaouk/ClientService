package com.example.demo;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
public class Client{
    @Id
    @SequenceGenerator(
            name="client_id_sequence",
            sequenceName = "client_id_sequence"

    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Integer id;
    private String name;
    private Integer Number;

    public Client(Integer id, String name, Integer number) {
        this.id = id;
        this.name = name;
        Number = number;
    }

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return Number;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Number=" + Number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client customer)) return false;
        return Objects.equals(getId(), customer.getId()) && Objects.equals(getName(), customer.getName()) && Objects.equals(getNumber(), customer.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getNumber());
    }
}
