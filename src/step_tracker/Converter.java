package step_tracker;

public class Converter {

    private double distance = 75;

    private int kalories = 50;

    public double converToKm(int sum) {
        double sam = (distance * sum) / 100000;
        return sam;
    }

    public int convertStepsToKilocalories(int sum) {
        int kal = (sum * kalories) / 1000;
        return kal;
    }

}
