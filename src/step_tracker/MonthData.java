package step_tracker;

public class MonthData {
    int[] days = new int[30]; //  modificator

    public void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println("За " + (i + 1) + " пройдено " + days[i] + " шагов");
        }
    }

    public int sumStepsFromMonth() {
        int sum = 0;
        for (int i = 0; i < days.length; i++) {
            sum += days[i];
        }
        return (sum);
    }

    public int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (maxSteps < days[i]) {
                maxSteps = days[i];
            }
        }
        return (maxSteps);
    }

    public int bestSeries(int goalByStepsPerDay) {
        int currentSeriesStep = 0;
        int bestSeriesStep = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeriesStep++;
            } else {
                if (bestSeriesStep < currentSeriesStep) {
                    bestSeriesStep = currentSeriesStep;
                }
                currentSeriesStep = 0;
            }
        }
        return bestSeriesStep;
    }

    public int middleSteps() {
        int middle = sumStepsFromMonth() / 30;
        return middle;
    }
}
