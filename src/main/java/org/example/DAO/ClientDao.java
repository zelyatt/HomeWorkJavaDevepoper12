package org.example.DAO;

import org.example.config.HibernateConfig;
import org.example.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDao {
    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    public void createClient(Client client){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }
    public Client getClient(Long id){
        try(Session session = sessionFactory.openSession()){
            return session.get(Client.class, id);
        }
    }
    public List<Client> getAllClients(){
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT c FROM Client c", Client.class).getResultList();

        }
    }
    public void updateClient(Client client){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }
    public void deleteClient(Long id){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null){
                session.remove(client);
                transaction.commit();
            }
        }
    }

}