package es.kernelpanic.ecogrid.containermagenement.controller.dto;

import lombok.Data;

@Data
public class ContainerDto {
    private Long id;
    private String identifier;
    private String type;
    private String center;
    private String location;
    private String latitude;
    private String longitude;
    private String capacity;
    private String unit;
}
