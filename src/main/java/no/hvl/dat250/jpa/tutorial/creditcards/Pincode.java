package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
public class Pincode {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pincode;

    @Setter
    @Getter
    private Integer count;

    public String getCode() {
        return pincode;
    }

    public void setCode(String number) {
        this.pincode = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pincode pincode = (Pincode) o;
        return Objects.equals(id, pincode.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
