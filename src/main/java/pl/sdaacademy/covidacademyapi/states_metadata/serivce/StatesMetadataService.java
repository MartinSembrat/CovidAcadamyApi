package pl.sdaacademy.covidacademyapi.states_metadata.serivce;

import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.states_metadata.repository.StatesMetadata;
import pl.sdaacademy.covidacademyapi.states_metadata.repository.StatesMetadataApi;
import pl.sdaacademy.covidacademyapi.states_metadata.repository.StatesMetadataDbRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class StatesMetadataService {

    private final StatesMetadataApi statesMetadataApi;
    private final StatesMetadataDbRepository statesMetadataDbRepository;

    public StatesMetadataService(StatesMetadataApi statesMetadataApi,
                                 StatesMetadataDbRepository statesMetadataDbRepository) {
        this.statesMetadataApi = statesMetadataApi;
        this.statesMetadataDbRepository = statesMetadataDbRepository;
    }

    public List<StatesMetadata> getStatesMetadata() {
        if(statesMetadataDbRepository.count() > 0) {
            return statesMetadataDbRepository.findAll();
        }
        List<StatesMetadata> statesMetadata =
                Arrays.asList(statesMetadataApi.getStatesMetadata());
        return statesMetadataDbRepository.saveAll(statesMetadata);
    }
}
