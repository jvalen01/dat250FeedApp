package no.hvl.dat250.appassignB.feedApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Poll {


    @Setter
    @Getter
    @Id
    private Long id;

    private String name;

    private boolean active;

}
