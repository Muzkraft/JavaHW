package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();

    }

    static void task4() {
/* Реализовать простой калькулятор
("введите первое число"... "Введите второе число"...
"укажите операцию, которую надо выполнить с этими числами"... "ответ: ...") */

        System.out.println("Калькулятор");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        double num1 = scanner.nextDouble();
        System.out.println("Введите второе число: ");
        double num2 = scanner.nextDouble();
        System.out.println("Введите действие (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        double result;

        switch (operator) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> result = num1 / num2;
            default -> {
                System.out.println("Что-то пошло не по плану! Кирдык!");
                return;
            }
        }
        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
   }

    static void task3() {
        /*  Вывести все простые числа от 1 до 1000
    (простые числа - это числа которые делятся только на себя и на единицу без остатка.
    Чтобы найти остаток от деления используйте оператор % , например 10%3 будет равно единице)*/

        boolean isSimple;

        for (int i = 1; i < 1000; i++) {
            isSimple = true;
            for (int j = 2; j <= i / j; j++) {
                if ((i % j) == 0){
                    isSimple = false;
                }
            }
            if (isSimple) {
                System.out.print(i + " ");
            }
        }
    }

    static void task2() {
//        Вычислить n! (произведение чисел от 1 до n)

        System.out.println("Введите число: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.printf("Произведение чисел от 1 до %d = %d", n, result);
    }

    static void task1() {
//        Вычислить n-ое треугольного число(сумма чисел от 1 до n)

        System.out.println("Введите число: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 0;

        for (int i = 1; i <= n; i++) {
            result += i;
        }
        System.out.printf("Сумма чисел от 1 до %d = %d", n, result);
    }

}