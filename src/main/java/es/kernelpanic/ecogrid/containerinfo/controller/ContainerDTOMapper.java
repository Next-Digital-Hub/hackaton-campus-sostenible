package es.kernelpanic.ecogrid.containerinfo.controller;

import es.kernelpanic.ecogrid.containermagenement.controller.dto.ContainerDto;
import es.kernelpanic.ecogrid.containermagenement.service.domain.Container;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContainerDTOMapper {

    ContainerViewItemDto toEntity(Container container);

    Container toDomain(ContainerViewItemDto containerViewItemDto);

    Container toDomain(ContainerDto containerEntity);

    List<ContainerViewItemDto> toDtoList(List<Container> containerList);
}
