package es.kernelpanic.ecogrid.containermagenement.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ContainerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
