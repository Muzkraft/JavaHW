package org.example;
/*Пусть дан список сотрудников:
 Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков,
 Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова,
 Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
 Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
 Отсортировать по убыванию популярности.
 Для сортировки использовать TreeMap.*/

import java.util.*;

public class Task2 {

    static String task2(String s) {
        String[] persons = s.split(", ");
        String[] names = new String[persons.length];
        for (int i = 0; i < persons.length; i++) {
            names[i] = persons[i].split(" ")[0];
        }

        TreeMap<String, Integer> treeMap = new TreeMap<>();

        for (String name : names) {
            int newValue = treeMap.getOrDefault(name, 0) + 1;
            treeMap.put(name, newValue);
        }

        List list = new ArrayList(treeMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        return list.toString();
    }
}
