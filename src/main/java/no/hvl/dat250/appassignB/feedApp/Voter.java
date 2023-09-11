package no.hvl.dat250.appassignB.feedApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Voter {

    @Id
    private Long id;

    private String username;



}
