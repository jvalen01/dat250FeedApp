package no.hvl.dat250.appassignB.feedApp.dao;


import jakarta.persistence.EntityManager;
import  no.hvl.dat250.appassignB.feedApp.*;

import java.util.List;

public class QuestionDAO extends AbstractDAO<Question, Long> {

    public QuestionDAO(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Question> getEntityClass() {
        return Question.class;
    }
}