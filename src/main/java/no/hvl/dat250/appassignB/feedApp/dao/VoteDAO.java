package no.hvl.dat250.appassignB.feedApp.dao;

import jakarta.persistence.EntityManager;
import  no.hvl.dat250.appassignB.feedApp.*;

import java.util.List;

public class VoteDAO extends AbstractDAO<Vote, Long> {

    public VoteDAO(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Vote> getEntityClass() {
        return Vote.class;
    }
}