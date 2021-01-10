package pl.sdaacademy.covidacademyapi.states_metadata.serivce;

import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.states_metadata.repository.StatesMetadata;
import pl.sdaacademy.covidacademyapi.states_metadata.repository.StatesMetadataApi;
import pl.sdaacademy.covidacademyapi.states_metadata.repository.StatesMetadataDbRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        return fetchStatesMetadata();
//        List<StatesMetadata> statesMetadata =
//                Arrays.asList(statesMetadataApi.getStatesMetadata());
//        return statesMetadataDbRepository.saveAll(statesMetadata);
    }
    private List<StatesMetadata> fetchStatesMetadata(){
        List<StatesMetadata> statesMetadata =
                Arrays.asList(statesMetadataApi.getStatesMetadata());
        return statesMetadataDbRepository.saveAll(statesMetadata);
    }

    public Optional<StatesMetadata> getStateByName (String name){
        if (statesMetadataDbRepository.count()==0){
            fetchStatesMetadata();
        }
        return statesMetadataDbRepository.findByNameIgnoreCase(name);

    }
    public Optional<StatesMetadata> getStateById(String id) {
        if (statesMetadataDbRepository.count() == 0) {
            fetchStatesMetadata();
        }
        return statesMetadataDbRepository.findById(id);
    }
}
