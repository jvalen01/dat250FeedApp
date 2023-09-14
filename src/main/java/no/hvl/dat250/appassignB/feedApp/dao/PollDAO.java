package no.hvl.dat250.appassignB.feedApp.dao;

import jakarta.persistence.EntityManager;
import  no.hvl.dat250.appassignB.feedApp.*;

import java.util.List;

public class PollDAO extends AbstractDAO<Poll, Long> {

    public PollDAO(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Poll> getEntityClass() {
        return Poll.class;
    }
}
