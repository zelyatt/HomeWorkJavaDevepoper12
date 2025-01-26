package org.example.service;


import org.example.DAO.PlanetDao;
import org.example.model.Planet;

import java.util.List;

public class PlanetCrudService {
    private final PlanetDao planetDao;

    public PlanetCrudService(PlanetDao planetDao) {
        this.planetDao = planetDao;
    }

    public void update (Planet planet) {
        planetDao.updatePlanet(planet);
    }

    public void save(Planet planet) {
        planetDao.createPlanet(planet);
    }

    public Planet findById(String id) {
        return planetDao.getPlanet(id);
    }

    public List<Planet> findAll() {
        return planetDao.getAllPlanets();
    }

    public void delete(String id) {
        Planet planet = findById(id);
        if (planet != null) {
            planetDao.deletePlanet(id);
        }
    }
}
