package es.kernelpanic.ecogrid.containermagenement.service.mappers;

import es.kernelpanic.ecogrid.containermagenement.repository.entity.ContainerEntity;
import es.kernelpanic.ecogrid.containermagenement.service.domain.Container;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContainerEntityMapper {
    ContainerEntity toEntity(Container container);

    Container toDomain(ContainerEntity containerEntity);
}
