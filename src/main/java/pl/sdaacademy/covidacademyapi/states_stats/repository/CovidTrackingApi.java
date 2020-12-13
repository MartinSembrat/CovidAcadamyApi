package pl.sdaacademy.covidacademyapi.states_stats.repository;

public interface CovidTrackingApi {

    StateStats[] getAllStatesCurrentStats();

    StateInfo[] getAllStatesInfo();

    StateStats getStatsForState(String state, String date);

}
