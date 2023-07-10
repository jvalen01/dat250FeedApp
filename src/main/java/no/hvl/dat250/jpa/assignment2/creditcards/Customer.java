package no.hvl.dat250.jpa.assignment2.creditcards;

import java.util.Collection;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        // TODO: implement method!
        return null;
    }

    public Collection<Address> getAddresses() {
        // TODO: implement method!
        return null;
    }

    public Collection<CreditCard> getCreditCards() {
        // TODO: implement method!
        return null;
    }
}
