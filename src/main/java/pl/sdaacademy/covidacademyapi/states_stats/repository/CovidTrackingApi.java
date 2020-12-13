package pl.sdaacademy.covidacademyapi.states_stats.repository;

public interface CovidTrackingApi {

    StateStats[] getAllStatesCurrentStats();

    StateStats getStatsForState(String state, String date);

}
