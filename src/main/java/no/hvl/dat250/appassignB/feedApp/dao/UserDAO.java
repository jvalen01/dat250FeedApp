package no.hvl.dat250.appassignB.feedApp.dao;


import jakarta.persistence.EntityManager;
import  no.hvl.dat250.appassignB.feedApp.*;

import java.util.List;

public class UserDAO extends AbstractDAO<User, Long> {

    public UserDAO(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}