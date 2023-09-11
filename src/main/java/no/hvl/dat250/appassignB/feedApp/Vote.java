package no.hvl.dat250.appassignB.feedApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vote {

    @Id
    private Integer id;

    private Boolean answer;

    @ManyToOne
    private Question question;

}
