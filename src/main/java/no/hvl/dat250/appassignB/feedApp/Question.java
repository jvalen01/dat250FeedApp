package no.hvl.dat250.appassignB.feedApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Question {

    @Id
    private Long id;

    private String question;

    private int yesVotes;

    private int noVotes;

    private int totalVotes;

    @ManyToOne
    private Poll poll;

    @OneToMany(mappedBy = "question")
    private List<Vote> votes;

}
