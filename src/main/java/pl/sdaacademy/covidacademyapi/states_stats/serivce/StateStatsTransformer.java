package pl.sdaacademy.covidacademyapi.states_stats.serivce;

import org.springframework.stereotype.Component;
import pl.sdaacademy.covidacademyapi.states_metadata.repository.StatesMetadata;
import pl.sdaacademy.covidacademyapi.states_stats.repository.StateStats;
@Component
public class StateStatsTransformer {
    public StateStatsDTO transformToDTO (StateStats stateStats, StatesMetadata statesMetadata){
        StateStatsDTO stateStatsDTO = new StateStatsDTO();
        stateStatsDTO.setStatesMetadata(statesMetadata);
        stateStatsDTO.setNegative(stateStats.getNegative());
        stateStatsDTO.setPositive(stateStats.getPositive());
        stateStatsDTO.setRecovered(stateStats.getRecovered());
        stateStatsDTO.setDeathConfirmed(stateStats.getDeathConfirmed());
        return stateStatsDTO;
    }
}
