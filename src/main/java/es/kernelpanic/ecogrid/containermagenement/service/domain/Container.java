package es.kernelpanic.ecogrid.containermagenement.service.domain;

import lombok.Data;

@Data
public class Container {
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
