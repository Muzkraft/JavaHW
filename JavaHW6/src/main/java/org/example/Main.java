package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Operation.laptopMap();

        System.out.println("Приветствуем Вас в нашем магазине ноутбуков!\n");
        System.out.println("Выберите желаемый критерий поиска или посмотрите весь список предложений: \n");
        System.out.println(Operation.criterionMap());
        System.out.print("\nВыберите пункт меню: ");

        int choice = sc.nextInt();
        Operation.operation(choice);
    }
}