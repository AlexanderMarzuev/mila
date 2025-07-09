package step_tracker;

import java.util.Scanner;

public class StepTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker track = new Tracker(scanner);

        while (true) {
            Menu.printMenu();
            int command = scanner.nextInt();
            switch(command){
                case 1:
                    track.addNewNumberStepsPerDay();
                    command = 1;
                    System.out.println("ввести количество шагов за определённый день;");
                    break;
                case 2:

                    command = 2;
                    System.out.println("изменить цель по количеству шагов в день;");
                    track.changeStepGoal();
                    break;
                case 3:
                    track.printStatistic();
                    command = 3;
                    System.out.println("напечатать статистику за определённый месяц;");
                    break;
                case 4:
                    command = 4;
                    System.out.println("выйти из приложения.");
                    break;
                default:
                    System.out.println("Веди число от 1 до 4");
            }
            if (command == 4){
                break;
            }
        }
    }
}

