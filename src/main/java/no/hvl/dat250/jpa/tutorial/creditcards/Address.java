package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.*;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String street;

    @Setter
    @Getter
    private Integer number;

    @ManyToMany(mappedBy = "addresses")
    private Set<Customer> customers = new HashSet<>();

    public Set<Customer> getOwners() {
        return customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setOwners(Set<Customer> ownersList) {
        this.customers = ownersList;
    }
}
