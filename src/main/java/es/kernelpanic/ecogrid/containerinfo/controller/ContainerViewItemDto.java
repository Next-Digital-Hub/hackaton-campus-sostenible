package es.kernelpanic.ecogrid.containerinfo.controller;

import lombok.Data;

@Data
public class ContainerViewItemDto {
    private String percentage;
    private String identifier;
    private String type;
    private String center;
    private String location;
}
