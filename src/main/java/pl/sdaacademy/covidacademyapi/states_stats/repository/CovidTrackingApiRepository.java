package pl.sdaacademy.covidacademyapi.states_stats.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CovidTrackingApiRepository implements CovidTrackingApi {

    private final RestTemplate restTemplate;
    private final String allStatesUrl;
    private final String specificStateUrl;

    public CovidTrackingApiRepository(RestTemplate restTemplate,
                                      @Value("${covidtrackingapi.url}") String allStatesUrl,
                                      @Value("${covidtrackingapi.specificstate.url}") String specificStateUrl) {
        this.allStatesUrl = allStatesUrl;
        this.restTemplate = restTemplate;
        this.specificStateUrl = specificStateUrl;
    }

    @Override
    public StateStats[] getAllStatesCurrentStats() {
        return restTemplate.getForObject(allStatesUrl, StateStats[].class);
    }

    @Override
    public StateStats getStatsForState(String state, String date) {
        return restTemplate.getForObject(String.format(specificStateUrl, state, date), StateStats.class);
    }
}
