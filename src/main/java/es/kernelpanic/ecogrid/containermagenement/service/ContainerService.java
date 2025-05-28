package es.kernelpanic.ecogrid.containermagenement.service;

import es.kernelpanic.ecogrid.containermagenement.service.domain.Container;

import java.util.List;

public interface ContainerService {
    void save(Container domain);

    List<Container> getAll();
}
