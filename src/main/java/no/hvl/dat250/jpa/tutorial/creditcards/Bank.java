package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
public class Bank {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String name;

    @OneToMany(mappedBy = "bank")
    private Set<CreditCard> creditCards = new HashSet<>();

    public Set<CreditCard> getOwnedCards() {
        return creditCards;
    }
    public void setOwnedCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(id, bank.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
