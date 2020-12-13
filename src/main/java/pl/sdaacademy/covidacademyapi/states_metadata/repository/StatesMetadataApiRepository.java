package pl.sdaacademy.covidacademyapi.states_metadata.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class StatesMetadataApiRepository implements StatesMetadataApi {

    private final RestTemplate restTemplate;
    private final String url;

    public StatesMetadataApiRepository(RestTemplate restTemplate, @Value("${covidtrackingapi.states_metadata.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @Override
    public StatesMetadata[] getStatesMetadata() {
        return restTemplate.getForObject(url, StatesMetadata[].class);
    }
}
