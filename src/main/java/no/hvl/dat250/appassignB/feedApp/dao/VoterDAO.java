package no.hvl.dat250.appassignB.feedApp.dao;

import jakarta.persistence.EntityManager;
import  no.hvl.dat250.appassignB.feedApp.*;

import java.util.List;

public class VoterDAO extends AbstractDAO<Voter, Long> {

    public VoterDAO(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Voter> getEntityClass() {
        return Voter.class;
    }
}