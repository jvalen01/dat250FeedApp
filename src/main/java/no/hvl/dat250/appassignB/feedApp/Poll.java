package no.hvl.dat250.appassignB.feedApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Poll {


    @Id
    private Long id;

    private String name;

    private Boolean active;

    private String accessMode;

    @OneToMany(mappedBy = "poll")
    private List<Question> questions;

}
