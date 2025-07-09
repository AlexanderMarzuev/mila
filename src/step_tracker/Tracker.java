package step_tracker;

import java.util.Scanner;

public class Tracker {
    private Converter converter = new Converter(); // modificator
    private Scanner scanner; // modificator
    private MonthData[] monthToData = new MonthData[12]; // modificator

    public int goalByStepsPerDay = 10000;

    Tracker(Scanner scanner) {
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        this.scanner = scanner;
    }

    public void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");

        int month = scanner.nextInt();

        if (month < 1 || month >= 13) {
            System.out.println("Ошибка");
            return;
        } else {
            System.out.println("Введите день");

        }
        int days = scanner.nextInt();

        if (days < 1 || days > 30) {
            System.out.println("Ошибка");
            return;
        } else {
            System.out.println("Введите количество шагов");
        }
        int steps = scanner.nextInt();

        if (steps < 1) {
            System.out.println("Отрицательный показатель");

        } else {
            System.out.println("Ваш результат сохранен");
        }
        MonthData monthData = monthToData[month - 1];
        monthData.days[days - 1] = steps;
    }

    public void changeStepGoal() {
        int goal = scanner.nextInt();
        if (goal >= 0) {
            goalByStepsPerDay = goal;
            System.out.println("Сохранено, теперь ваша цель " + goalByStepsPerDay + " шагов!");

        } else {
            System.out.println("Ошибка");
        }
    }

    public void printStatistic() {

        System.out.println("Введите номер месяца!");
        int month = scanner.nextInt();

        if (month <= 0 || month >= 13) {
            System.out.println("Ошибка");
        } else {
            System.out.println("Вот статистика за " + month + " месяц:");
        }

        MonthData numberMonth = monthToData[month - 1];
        numberMonth.printDaysAndStepsFromMonth(); // зачем используется
        int sumStep = numberMonth.sumStepsFromMonth();
        int maxStep = numberMonth.maxSteps();
        int middle = numberMonth.middleSteps();
        double sam = converter.converToKm(sumStep);
        int kal = converter.convertStepsToKilocalories(sumStep);
        int best = numberMonth.bestSeries(goalByStepsPerDay);
        System.out.println(best);
        System.out.println("За этот месяц вы прошли " + sumStep + " шагов" + "\n" + "Максимально пройденное количество шагов за месяц составило " + maxStep + "\n" + "Среднее количество шагов в день составило " + middle + "\n" + "За этот месяц вы прошли " + sam + " километров" + "\n" + "За этот месяц вы сожгли " + kal + " килокалорий" + "\n" + "Лучшая серия шагов за месяц " + best ); // Объединить в один sout
    }

}