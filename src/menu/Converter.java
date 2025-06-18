package menu;

import java.util.Scanner;

public class Converter {
    public void convertCurrency(Scanner scanner, double moneyBeforeSalary) {
        double rateUSD = 78.5;
        double rateEUR = 85;
        double rateJPY = 0.74;
        double rateCNY = 10.95;

        System.out.println("Ваши сбережения: " + moneyBeforeSalary + " RUB");
        System.out.println("В какую валюту хотите конвертировать? Доступные варианты: 1 - USD, 2 - EUR, 3 - JPY, 4 - CNY.");
        int currency = scanner.nextInt();
        if (currency == 1) {
            System.out.println("Ваши сбережения в долларах: " + moneyBeforeSalary / rateUSD);
        } else if (currency == 2) {
            System.out.println("Ваши сбережения в евро: " + moneyBeforeSalary / rateEUR);
        } else if (currency == 3) {
            System.out.println("Ваши сбережения в иенах: " + moneyBeforeSalary / rateJPY);
        } else if (currency == 4) {
            System.out.println("Ваши сбережения в юанях: " + moneyBeforeSalary / rateCNY);
        } else {
            System.out.println("Неизвестная валюта");
        }
    }
}