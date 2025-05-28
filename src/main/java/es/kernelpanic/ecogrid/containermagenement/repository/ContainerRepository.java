package es.kernelpanic.ecogrid.containermagenement.repository;

import es.kernelpanic.ecogrid.containermagenement.repository.entity.ContainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerRepository extends JpaRepository<ContainerEntity, String> {
}
