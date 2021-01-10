package pl.sdaacademy.covidacademyapi.states_stats.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.covidacademyapi.states_stats.serivce.StateStatsDTO;
import pl.sdaacademy.covidacademyapi.states_stats.serivce.StatesStatsService;

import java.util.List;

@RequestMapping("/states")
@RestController
public class StatesStatsController {

    private final StatesStatsService statesStatsService;

    @Autowired
    public StatesStatsController(StatesStatsService statesStatsService) {
        this.statesStatsService = statesStatsService;
    }

    @GetMapping
    public List<StateStatsDTO> getCurrentStateStats() {
        return statesStatsService.getAllStatesCurrentStats();
    }

    @GetMapping("/{state}/{date}")
    public StateStatsDTO getStatsForState(@PathVariable String state, @PathVariable String date) {
        return statesStatsService.getStatsForState(state, date);
    }
}
