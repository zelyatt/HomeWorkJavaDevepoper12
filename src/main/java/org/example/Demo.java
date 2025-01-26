package org.example;

import org.example.DAO.ClientDao;
import org.example.DAO.PlanetDao;
import org.example.model.Client;
import org.example.model.Planet;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // Create DAO and services
        ClientDao clientDao = new ClientDao();
        PlanetDao planetDao = new PlanetDao();

        ClientCrudService clientService = new ClientCrudService(clientDao);
        PlanetCrudService planetService = new PlanetCrudService(planetDao);

        // Testing CRUD operations for Client
        System.out.println("=== Testing Client CRUD ===");
        Client client = new Client();
        client.setName("John Doe");

        // Create operation
        clientService.save(client);
        System.out.println("Client created: " + client);

        // Read operation
        Client retrievedClient = clientService.findById(client.getId());
        System.out.println("Client retrieved: " + retrievedClient.getName());

        // Update operation
        retrievedClient.setName("Jane Doe");
        clientService.update(retrievedClient);
        System.out.println("Client updated: " + retrievedClient.getName());

        // Delete operation
        clientService.delete(retrievedClient.getId());
        System.out.println("Client deleted.");

        // Testing CRUD operations for Planet
        System.out.println("=== Testing Planet CRUD ===");
        Planet planet = new Planet();
        planet.setId("MARS001");
        planet.setName("Mars");

        // Create operation
        planetService.save(planet);
        System.out.println("Planet created: " + planet);

        // Read operation
        Planet retrievedPlanet = planetService.findById(planet.getId());
        System.out.println("Planet retrieved: " + retrievedPlanet.getName());

        // Update operation
        retrievedPlanet.setName("Red Planet");
        planetService.update(retrievedPlanet);
        System.out.println("Planet updated: " + retrievedPlanet.getName());

        // Delete operation
        planetService.delete(retrievedPlanet.getId());
        System.out.println("Planet deleted.");

        // Retrieve all records
        System.out.println("=== Retrieving All Records ===");
        List<Client> allClients = clientService.findAll();
        System.out.println("All clients: " + allClients);

        List<Planet> allPlanets = planetService.findAll();
        System.out.println("All planets: " + allPlanets);
    }
}
