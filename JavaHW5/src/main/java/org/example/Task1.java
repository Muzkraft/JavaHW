package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    static void task1() {
        /*Реализуйте структуру телефонной книги с помощью HashMap,
         учитывая, что 1 человек может иметь несколько телефонов.*/
        System.out.println("Phone book:");
        System.out.println();
        HashMap<String, List<Integer>> phoneBook = new HashMap<>();
        phoneBook.put("Иванов", Arrays.asList(123123, 1231321));
        phoneBook.put("Петрова", Arrays.asList(234234));
        phoneBook.put("Белова", Arrays.asList(345345, 345543));
        phoneBook.put("Мусина", Arrays.asList(456456));
        phoneBook.put("Крутова", Arrays.asList(567567, 765567, 657756));
        phoneBook.put("Юрин", Arrays.asList(678678));
        phoneBook.put("Лыков", Arrays.asList(876567, 756234));

        for (String person : phoneBook.keySet()) {
            System.out.println(person);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Введите имя контакта: ");
        String contact = sc.nextLine();

        if (phoneBook.containsKey(contact)) {
            System.out.println("Тел: " + phoneBook.get(contact));
        }
    }
}
