package sdaacademy.covidacademyapi.states_stats.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.states_stats.repository.CovidTrackingApi;
import pl.sdaacademy.covidacademyapi.states_stats.repository.StateCurrentStats;

@Service
public class StatesStatsService {

    private final CovidTrackingApi covidTrackingApi;

    @Autowired
    public StatesStatsService(CovidTrackingApi covidTrackingApi) {
        this.covidTrackingApi = covidTrackingApi;
    }

    public StateCurrentStats[] getAllStatesCurrentStats() {
        //logika bizensowa, np. mapowanie, validacja, itp
        return covidTrackingApi.getAllStatesCurrentStats();
    }
}
