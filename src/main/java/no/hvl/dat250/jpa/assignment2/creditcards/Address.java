package no.hvl.dat250.jpa.assignment2.creditcards;

import java.util.Collection;
import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getStreet() {
        // TODO: implement method!
        return null;
    }

    public Integer getNumber() {
        // TODO: implement method!
        return null;
    }

    public Collection<Customer> getOwners() {
        // TODO: implement method!
        return null;
    }
}
