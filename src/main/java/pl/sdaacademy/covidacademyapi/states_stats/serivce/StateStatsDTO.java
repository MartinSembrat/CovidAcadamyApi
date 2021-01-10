package pl.sdaacademy.covidacademyapi.states_stats.serivce;

import pl.sdaacademy.covidacademyapi.states_metadata.repository.StatesMetadata;

public class StateStatsDTO {

    private StatesMetadata statesMetadata;
    private int positive;
    private int negative;
    private int deathConfirmed;
    private int recovered;

    public void setStatesMetadata(StatesMetadata statesMetadata) {
        this.statesMetadata = statesMetadata;
    }

    public int getPositive() {
        return positive;
    }

    public void setPositive(int positive) {
        this.positive = positive;
    }

    public int getNegative() {
        return negative;
    }

    public void setNegative(int negative) {
        this.negative = negative;
    }

    public int getDeathConfirmed() {
        return deathConfirmed;
    }

    public void setDeathConfirmed(int deathConfirmed) {
        this.deathConfirmed = deathConfirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    //public StatesMetadata getStatesMetadata(){return statesMetadata;}
}
