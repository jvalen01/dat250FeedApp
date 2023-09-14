package no.hvl.dat250.appassignB.feedApp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public abstract class AbstractDAO<T, K> implements GenericDAO<T, K> {

    protected EntityManager em;

    public AbstractDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void persist(T entity) {
        em.persist(entity);
    }

    @Override
    public void remove(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Override
    public T find(K id) {
        return em.find(getEntityClass(), id);
    }

    @Override
    public List<T> findAll() {
        TypedQuery<T> query = em.createQuery("SELECT obj FROM " + getEntityClass().getSimpleName() + " obj", getEntityClass());
        return query.getResultList();
    }

    @Override
    public T update(T entity) {
        return em.merge(entity);
    }

    // Abstract method to get the entity class, to be implemented by concrete DAOs
    protected abstract Class<T> getEntityClass();
}
