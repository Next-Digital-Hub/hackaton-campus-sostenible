package es.kernelpanic.ecogrid.containermagenement.service;

import es.kernelpanic.ecogrid.containermagenement.repository.ContainerRepository;
import es.kernelpanic.ecogrid.containermagenement.service.domain.Container;
import es.kernelpanic.ecogrid.containermagenement.service.mappers.ContainerEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContainerServiceImpl implements ContainerService {
    private final ContainerRepository containerRepository;
    private final ContainerEntityMapper containerMapper;

    @Override
    public void save(final Container container) {
        this.containerRepository.save(
                this.containerMapper.toEntity(container)
        );
    }

    @Override
    public List<Container> getAll() {
        return this.containerRepository.findAll().stream()
                .map(this.containerMapper::toDomain)
                .toList();
    }
}
