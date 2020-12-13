package pl.sdaacademy.covidacademyapi.states_stats.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CovidTrackingApiRepository implements CovidTrackingApi {

    private final RestTemplate restTemplate;
    private final String allStatesUrl;
    private final String specificStateUrl;
    private final String statedatadtrackingUrl;

    public CovidTrackingApiRepository(RestTemplate restTemplate,
                                      @Value("${covidtrackingapi.url}") String allStatesUrl,
                                      @Value("${covidtrackingapi.specificstate.url}") String specificStateUrl,
                                      @Value("${statedatadtrackingapi.url}") String statedatadtrackingUrl) {
        this.allStatesUrl = allStatesUrl;
        this.restTemplate = restTemplate;
        this.specificStateUrl = specificStateUrl;
        this.statedatadtrackingUrl = statedatadtrackingUrl;
    }

    @Override
    public StateStats[] getAllStatesCurrentStats() {
        return restTemplate.getForObject(allStatesUrl, StateStats[].class);
    }

    @Override
    public StateStats getStatsForState(String state, String date) {
        return restTemplate.getForObject(String.format(specificStateUrl, state, date), StateStats.class);
    }

    @Override
    public StateInfo[] getAllStatesInfo(){
        return restTemplate.getForObject(statedatadtrackingUrl, StateInfo[].class);
    }
}
