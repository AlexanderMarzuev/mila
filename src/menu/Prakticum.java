package menu;

import java.util.Scanner;

public class Prakticum {
    public static void main(String[] args) {
        double[] expenses = new double[7];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько денег у вас осталось до зарплаты?");
        double moneyBeforeSalary = scanner.nextDouble();
        System.out.println("Сколько дней до зарплаты?");
        int daysBeforeSalary = scanner.nextInt();
        Expenses a = new Expenses();
        while (true) {
            Menu.printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                Converter c = new Converter();
                c.convertCurrency(scanner, moneyBeforeSalary);
            } else if (command == 2) {
                Advice b = new Advice();
                b.getAdvice(moneyBeforeSalary, daysBeforeSalary);
            } else if (command == 3) {
                moneyBeforeSalary = a.saveExpense(scanner, moneyBeforeSalary, expenses);
                // Перенесите код ниже в метод saveExpense
                // Вызовите метод с помощью такой строки:
                // moneyBeforeSalary = saveExpense(scanner, moneyBeforeSalary, expenses);

            } else if (command == 4) {
                a.printAllExpenses(expenses);
                // Перенесите обработку команды в метод printAllExpenses, здесь вызовите его

            } else if (command == 5) {
                double maxExpense = a.findMaxExpense(expenses);   // Перенесите поиск максимальной траты в метод findMaxExpense
                // Печать должна остаться здесь — для получения максимальной траты нужно вызвать метод
                System.out.println("Самая большая сумма расходов на этой неделе составила " + maxExpense + " руб.");
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }
}

