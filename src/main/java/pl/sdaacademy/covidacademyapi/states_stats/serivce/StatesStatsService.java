package pl.sdaacademy.covidacademyapi.states_stats.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.states_stats.repository.CovidTrackingApi;
import pl.sdaacademy.covidacademyapi.states_stats.repository.StateStats;

@Service
public class StatesStatsService {

    private final CovidTrackingApi covidTrackingApi;

    @Autowired
    public StatesStatsService(CovidTrackingApi covidTrackingApi) {
        this.covidTrackingApi = covidTrackingApi;
    }

    public StateStats[] getAllStatesCurrentStats() {
        //logika bizensowa, np. mapowanie, validacja, itp
        return covidTrackingApi.getAllStatesCurrentStats();
    }

    public StateStats getStatsForState(String state, String date) {
        return covidTrackingApi.getStatsForState(state, date);
    }
}
