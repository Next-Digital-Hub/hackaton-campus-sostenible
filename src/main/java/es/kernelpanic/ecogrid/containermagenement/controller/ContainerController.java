package es.kernelpanic.ecogrid.containermagenement.controller;

import es.kernelpanic.ecogrid.containermagenement.controller.dto.ContainerDto;
import es.kernelpanic.ecogrid.containermagenement.controller.mapper.ContainerDTOMapper;
import es.kernelpanic.ecogrid.containermagenement.service.ContainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/container")
@RequiredArgsConstructor
public class ContainerController {
    private final ContainerService containerService;
    private final ContainerDTOMapper containerMapper;

    @GetMapping()
    public String containerListView(final Model model) {
        List<ContainerDto> containersDto = this.containerMapper.toDtoList(this.containerService.getAll());
        model.addAttribute("containers", containersDto);
        return "containermanagement/container_list";
    }

    @GetMapping("/create")
    public String newContainerView(final Model model) {
        model.addAttribute("container", new ContainerDto());
        return "containermanagement/container_form";
    }

    @PostMapping("/create")
    public String newContainerSubmit(ContainerDto container) {
        this.containerService.save(
                this.containerMapper.toDomain(container)
        );
        return "redirect:/admin/container/create";
    }

}
