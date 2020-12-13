package pl.sdaacademy.covidacademyapi.states_metadata.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.covidacademyapi.states_metadata.serivce.StatesMetadataService;
import pl.sdaacademy.covidacademyapi.states_metadata.repository.StatesMetadata;

import java.util.List;

@RequestMapping("/info")
@RestController
public class StatesMetadataController {

    private StatesMetadataService statesMetadataService;

    public StatesMetadataController(StatesMetadataService statesMetadataService) {
        this.statesMetadataService = statesMetadataService;
    }

    @GetMapping
    public List<StatesMetadata> getStatesMetadata() {
        return statesMetadataService.getStatesMetadata();
    }
}
