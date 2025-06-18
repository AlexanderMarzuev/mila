package Menu;

import java.util.Scanner;

public class Praktikum {
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


    public static class Menu {
        public static void printMenu() {
            System.out.println("Что вы хотите сделать? ");
            System.out.println("1 - Конвертировать валюту");
            System.out.println("2 - Получить совет");
            System.out.println("3 - Ввести трату");
            System.out.println("4 - Показать траты за неделю");
            System.out.println("5 - Показать самую большую сумму расходов за неделю");
            System.out.println("0 - Выход");
        }
    }

    public static class Expenses {

        public double saveExpense(Scanner scanner, double moneyBeforeSalary, double[] expenses) {
             /* Добавьте здесь метод saveExpense, который будет сохранять значение расходов пользователя.
               saveExpense также должен возвращать новое значение остатка средств. */

            System.out.println("За какой день вы хотите ввести трату: 1-ПН, 2-ВТ, 3-СР, 4-ЧТ, 5-ПТ, 6-СБ, 7-ВС?");
            int day = scanner.nextInt();
            System.out.println("Введите размер траты:");
            double expense = scanner.nextDouble();
            moneyBeforeSalary = moneyBeforeSalary - expense;
            expenses[day - 1] = expenses[day - 1] + expense;
            System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
            if (moneyBeforeSalary < 1000) {
                System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
            }
            return moneyBeforeSalary;
        }

        public void printAllExpenses(double[] expenses) { // Объявите и реализуйте здесь метод printAllExpenses
            for (int i = 0; i < expenses.length; i++) {
                System.out.println("День " + (i + 1) + ". Потрачено " + expenses[i] + " рублей");
            }
        }

        public double findMaxExpense(double[] expenses) { // Напишите метод findMaxExpense — он должен возвращать значение максимальной траты
            double maxExpense = 0;
            for (int i = 0; i < expenses.length; i++) {
                if (expenses[i] > maxExpense) {
                    maxExpense = expenses[i];
                }
            }
            return maxExpense;
        }


    }

    public static class Converter {
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

    public static class Advice {
        public void getAdvice(double moneyBeforeSalary, int daysBeforeSalary) {
            if (moneyBeforeSalary < 3000) {
                System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
            } else if (moneyBeforeSalary < 10000) {
                if (daysBeforeSalary < 10) {
                    System.out.println("Окей, пора в Макдак!");
                } else {
                    System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
                }
            } else if (moneyBeforeSalary < 30000) {
                if (daysBeforeSalary < 10) {
                    System.out.println("Неплохо! Прикупите долларов и зайдите поужинать в классное место. :)");
                } else {
                    System.out.println("Окей, пора в Макдак!");
                }
            } else {
                if (daysBeforeSalary < 10) {
                    System.out.println("Отлично! Заказывайте крабов!");
                } else {
                    System.out.println("Неплохо! Прикупите долларов и зайдите поужинать в классное место. :)");
                }
            }
        }
    }
}

