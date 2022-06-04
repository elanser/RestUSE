package com.example.RestUSE.Repositories;
import com.example.RestUSE.Entity.User;
import com.example.RestUSE.Repositories.Interfaces.IUSEUserRepository;


import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static com.example.RestUSE.RestUseApplication.sessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DBUserRepository implements IUSEUserRepository {
    private Session session;
    private CriteriaBuilder criteriaBuilder;

    @Override
    public User getUserByLogin(String login) {
        Optional<User> result = Optional.empty();
        List<User> list;
        session = sessionFactory.openSession();
        criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
        Root<User> rootUser = criteria.from(User.class);
        criteria.select(rootUser).where(criteriaBuilder.equal(rootUser.get("login"),login));
        Query<User> query = session.createQuery(criteria);
        list = query.getResultList();
        if (list.size()>0) {
            result = Optional.ofNullable(list.get(0));
        }
        return result.orElseGet(User::new);
    }

    @Override
    public User getUserById(Long id) {
        session = sessionFactory.openSession();
        criteriaBuilder = session.getCriteriaBuilder();
        User user = null;
        try {
            session = sessionFactory.openSession();
            user = session.get(User.class,id);
            Hibernate.initialize(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public User getUserByLoginPassword(String login, String password) {
        Optional<User> result = Optional.empty();
        try {
            session = sessionFactory.openSession();
            criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
            Root<User> rootUser = criteria.from(User.class);
            List<User> list;
            Predicate[] predicates = new Predicate[2];
            predicates[0] = criteriaBuilder.equal(rootUser.get("login"),login);
            predicates[1] = criteriaBuilder.equal(rootUser.get("password"),password);
            criteria.select(rootUser).where(predicates);
            Query<User> query = session.createQuery(criteria);
            list = query.getResultList();
            if (list.size()>0) {
                result = Optional.ofNullable(list.get(0));
            }
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return result.orElseGet(User::new);
    }

    @Override
    public List<User> getUsers() {
        Query<User> query;
        Optional<List<User>> result;
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> criteria = builder.createQuery(User.class);
            Root<User> rootUser = criteria.from(User.class);
            criteria.select(rootUser);
            query = session.createQuery(criteria);
            result = Optional.ofNullable(query.getResultList());
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return  result.orElseGet(ArrayList::new);
    }

    @Override
    public Boolean isUser(String login) {
        return (getUserByLogin(login) != null);
    }
}
