package org.example;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        System.out.printf("Первый элемент -> %d\n", q.first());

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        if (q.isEmpty()) {
            System.out.println("Очередь пуста");
        }
        else {
            System.out.println("Очередь не пуста");
        }

        System.out.println();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        System.out.println("Исходный лист -> "+ linkedList);
        task1(linkedList);
        task2(linkedList);
    }
    static void task1(LinkedList<Integer> linkedList) {
        /*Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.*/

        LinkedList<Integer> list2 = new LinkedList<>();
        for (int i = linkedList.size() -1; i >= 0; i--) {
            list2.add(linkedList.get(i));
        }
        System.out.println("Перевернутый лист -> "+ list2);
    }
    static void task2(LinkedList<Integer> linkedList) {
        /*Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор*/

        int sum = 0;
        for (Integer num: linkedList) {
            sum += num;
        }
        System.out.println("Сумма элементов -> "+ sum);
    }
}