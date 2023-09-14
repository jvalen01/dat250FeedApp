package no.hvl.dat250.appassignB.feedApp;
import no.hvl.dat250.appassignB.feedApp.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.appassignB.feedApp.driver.FeedAppMain;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FeedAppTest {

    private EntityManagerFactory factory;

    @Before
    public void setUp() {
        factory = Persistence.createEntityManagerFactory(FeedAppMain.PERSISTENCE_UNIT_NAME);
    }

    @Test
    public void testDomainModelPersistence() {
        // Run the main class to persist the objects.
        FeedAppMain.main(new String[]{});

        EntityManager em = factory.createEntityManager();

        // Load user
        User user = em.find(User.class, 1L);

        // Test person data
        assertThat(user.getUsername(), is("Bob"));
        assertThat(user.getPassword(), is("123456789"));



        // Test address
        assertThat(user.getVotes().size(), is(1));
        Vote vote = user.getVotes().iterator().next();

        assertThat(vote.getAnswer(), is(true));
        assertThat(vote.getQuestion().getQuestion(), is("What is this?"));
        Question question = vote.getQuestion();
        assertThat(question.getPoll().getName(), is("TestPoll"));


    }
}
