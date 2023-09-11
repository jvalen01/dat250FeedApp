package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private Integer number;

    @Setter
    @Getter
    private Integer creditLimit;

    @Setter
    @Getter
    private Integer balance;

    @Setter
    @Getter
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Pincode pincode;

    @Setter
    @Getter
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Bank bank;

    public Bank getOwningBank() {
        return bank;
    }

    public void setOwningBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
