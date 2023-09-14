package no.hvl.dat250.appassignB.feedApp.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import no.hvl.dat250.appassignB.feedApp.*;
import no.hvl.dat250.appassignB.feedApp.dao.*;

public class FeedAppMain {

    public static final String PERSISTENCE_UNIT_NAME = "feedApp";

    public static void main(String[] args) {
        try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
            em.getTransaction().begin();
            createObjects(em);
            em.getTransaction().commit();
        }

    }

    private static void createObjects(EntityManager em) {

        UserDAO userdao = new UserDAO(em);
        PollDAO polldao = new PollDAO(em);
        QuestionDAO questiondao = new QuestionDAO(em);
        VoteDAO votedao = new VoteDAO(em);


        User user = new User();
        user.setUsername("Bob");
        user.setPassword("123456789");
        user.setAdminRights(false);
        userdao.persist(user);
        // Persist early so that the user entity has its ID set

        Poll poll = new Poll();
        poll.setName("TestPoll");
        poll.setActive(true);
        poll.setAccessMode("public");
        poll.setUser(user);
        user.getPolls().add(poll);
        polldao.persist(poll);

        Question question = new Question();
        question.setQuestion("What is this?");
        question.setNoVotes(0);
        question.setTotalVotes(1);
        question.setYesVotes(1);
        question.setPoll(poll);
        poll.getQuestions().add(question);
        questiondao.persist(question);

        Vote vote = new Vote();
        vote.setAnswer(true);
        vote.setQuestion(question);
        question.getVotes().add(vote);
        vote.setUser(user);
        user.getVotes().add(vote);
        votedao.persist(vote);
    }



}
