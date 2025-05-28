package es.kernelpanic.ecogrid.containermagenement.controller.mapper;

import es.kernelpanic.ecogrid.containermagenement.controller.dto.ContainerDto;
import es.kernelpanic.ecogrid.containermagenement.service.domain.Container;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContainerDTOMapper {
    ContainerDto toDto(Container container);

    Container toDomain(ContainerDto containerEntity);

    List<ContainerDto> toDtoList(List<Container> containerList);
}
