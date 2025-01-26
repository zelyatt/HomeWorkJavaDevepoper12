package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.DAO.ClientDao;
import org.example.model.Client;
import org.hibernate.Session;

import java.util.List;

public class ClientCrudService {
    private final ClientDao clientDao;

    public ClientCrudService(ClientDao clientDao) {
        this.clientDao = clientDao;

    }

    public void save(Client client) {
        clientDao.createClient(client);
    }

    public Client findById(Long id) {
        return clientDao.getClient(id);
    }

    public void update(Client client) {
        clientDao.updateClient(client);
    }
    public List<Client> findAll() {
        return clientDao.getAllClients();
    }

    public void delete(Long id) {
        Client client = findById(id);
        if (client != null) {
            clientDao.deleteClient(id);
        }
    }
}
