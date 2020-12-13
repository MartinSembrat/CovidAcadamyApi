package pl.sdaacademy.covidacademyapi.states_stats.repository;

public class StateStats {

    private String state;
    private int positive;
    private int negative;
    private int deathConfirmed;
    private int recovered;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
}
