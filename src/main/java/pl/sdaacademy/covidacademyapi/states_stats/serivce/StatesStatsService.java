package pl.sdaacademy.covidacademyapi.states_stats.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.states_metadata.repository.StatesMetadata;
import pl.sdaacademy.covidacademyapi.states_metadata.serivce.StatesMetadataService;
import pl.sdaacademy.covidacademyapi.states_stats.repository.CovidTrackingApi;
import pl.sdaacademy.covidacademyapi.states_stats.repository.StateStats;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatesStatsService {

    private final CovidTrackingApi covidTrackingApi;
    private final StatesMetadataService statesMetadataService;
    private final StateStatsTransformer stateStatsTransformer;

    @Autowired
    public StatesStatsService(StatesMetadataService statesMetadataService, CovidTrackingApi covidTrackingApi,StateStatsTransformer stateStatsTransformer) {
        this.covidTrackingApi = covidTrackingApi;
        this.statesMetadataService = statesMetadataService;
        this.stateStatsTransformer = stateStatsTransformer;
    }
//    public StateStats[] getAllStatesCurrentStats() {
//        //logika bizensowa, np. mapowanie, validacja, itp
//        return covidTrackingApi.getAllStatesCurrentStats();
//    }

public List<StateStatsDTO> getAllStatesCurrentStats() {
    return Arrays.stream(covidTrackingApi.getAllStatesCurrentStats())
            .map(stateStats->{
                StatesMetadata statesMetadata =
                        statesMetadataService.getStateById(stateStats.getState()).get();
                return stateStatsTransformer.transformToDTO(stateStats, statesMetadata);
            })
            .collect(Collectors.toList());
}
    public StateStatsDTO getStatsForState(String state, String date) {
        StatesMetadata statesMetadata = statesMetadataService.getStateByName(state)
                .orElseThrow(()->{
                    throw new NoStateFoundException(state);
                });
        String acronym = statesMetadata.getState();
        StateStats stateStats = covidTrackingApi.getStatsForState(acronym, date);
        return stateStatsTransformer.transformToDTO(stateStats, statesMetadata);
    }
}
