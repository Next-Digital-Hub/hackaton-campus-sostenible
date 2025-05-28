package es.kernelpanic.ecogrid.conatinerapi;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ApiCallController {
    public int getContainerLivePercent(@PathVariable String containerId) {
        String url = "https://hackaton-campus-sostenible-api.mmartinez-d6a.workers.dev/containers/measurements";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer campus-sostenible-2025");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        ResponseEntity<ContainerDTO[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                ContainerDTO[].class
        );
        ContainerDTO[] containers = response.getBody();
        for (ContainerDTO container : containers) {
            if (container.getId().equals(containerId)) {
                ContainerDTO.HistoryEntry lastEntry = container.getHistory().get(container.getHistory().size() - 1);
                return lastEntry.getLevelPercent();
            }
        }
        return 0;
    }

    public List<ContainerDTO.HistoryEntry> getContainerHistory(@PathVariable String containerId) {
        String url = "https://hackaton-campus-sostenible-api.mmartinez-d6a.workers.dev/containers/measurements";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer campus-sostenible-2025");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        ResponseEntity<ContainerDTO[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                ContainerDTO[].class
        );
        ContainerDTO[] containers = response.getBody();
        for (ContainerDTO container : containers) {
            if (container.getId().equals(containerId)) {
                return container.getHistory();
            }
        }
        return null;
    }
}
