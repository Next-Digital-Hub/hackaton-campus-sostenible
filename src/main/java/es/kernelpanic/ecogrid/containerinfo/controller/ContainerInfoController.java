package es.kernelpanic.ecogrid.containerinfo.controller;

import es.kernelpanic.ecogrid.conatinerapi.ApiCallController;
import es.kernelpanic.ecogrid.containermagenement.controller.mapper.ContainerDTOMapper;
import es.kernelpanic.ecogrid.containermagenement.service.ContainerService;
import es.kernelpanic.ecogrid.containermagenement.service.domain.Container;
import lombok.Data;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

@Data
@Controller
@RequestMapping("/info/container")
public class ContainerInfoController {
    private final ContainerService containerService;
    private final ContainerDTOMapper containerMapper;
    private final ApiCallController apiCallController;

    @GetMapping()
    public String containerInfoView(final Model model) {
        List<Container> containers = this.containerService.getAll();
        List<ContainerViewItemDto> containerViewItemDto = new LinkedList<>();

        for (final Container container : containers){
            ContainerViewItemDto containerDto = new ContainerViewItemDto();
            int percent = apiCallController.getContainerLivePercent(container.getIdentifier());
            containerDto.setPercentage(percent + "%");
            containerDto.setLocation(container.getLocation());
            containerDto.setIdentifier(container.getIdentifier());
            containerDto.setType(container.getType());
            containerDto.setCenter(container.getCenter());
            containerViewItemDto.add(containerDto);

        }
        model.addAttribute("containers", containerViewItemDto);
        return "containerview/VisualizacionContenedores";
    }
}
