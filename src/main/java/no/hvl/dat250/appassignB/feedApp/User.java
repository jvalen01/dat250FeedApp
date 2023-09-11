package no.hvl.dat250.appassignB.feedApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {

    @Setter
    @Getter
    @Id
    private Long id;
    private String username;
    private String password;

    private boolean adminRights;

}
