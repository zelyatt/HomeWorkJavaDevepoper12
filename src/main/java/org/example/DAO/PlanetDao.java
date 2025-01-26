package org.example.DAO;


import org.example.config.HibernateConfig;
import org.example.model.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    public void createPlanet(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(planet);
        }
    }

    public Planet getPlanet(String id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void updatePlanet(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(planet);
            transaction.commit();
        }
    }
    public List<Planet> getAllPlanets (){
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("SELECT p FROM Planet p", Planet.class).getResultList();

        }
    }


    public void deletePlanet(String id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(getPlanet(id));
            transaction.commit();
        }
    }
}

