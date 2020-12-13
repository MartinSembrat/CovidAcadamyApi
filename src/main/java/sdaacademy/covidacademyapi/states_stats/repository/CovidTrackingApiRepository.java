package sdaacademy.covidacademyapi.states_stats.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CovidTrackingApiRepository implements CovidTrackingApi {

    private final RestTemplate restTemplate;
    private final String url;

    public CovidTrackingApiRepository(RestTemplate restTemplate,
                                      @Value("${covidtrackingapi.url}") String url) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    @Override
    public StateCurrentStats[] getAllStatesCurrentStats() {
        return restTemplate.getForObject(url, StateCurrentStats[].class);
    }
}
