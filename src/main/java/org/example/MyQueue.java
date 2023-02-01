package org.example;
/*Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.*/

// Узел связанного списка
class Node {
    int data;       // целочисленные данные
    Node next;      // указатель на следующий узел
    public Node(int data) {
        // устанавливаем данные в выделенном узле и возвращаем их
        this.data = data;
        this.next = null;
    }
}
public class MyQueue {
    private static Node rear = null, front = null;
    private static int count = 0;

    // Вспомогательная функция для удаления переднего элемента из очереди
    public static int dequeue() {    // удалить в начале
        if (front == null) {
            System.out.println("\nQueue Underflow");
            System.exit(-1);
        }
        Node temp = front;
        System.out.printf("Removing %d\n", temp.data);

        // продвигаемся вперед к следующему узлу
        front = front.next;

        // если список станет пустым
        if (front == null) {
            rear = null;
        }
        // уменьшить количество узлов на 1
        count -= 1;

        // вернуть удаленный элемент
        return temp.data;
    }
    // Вспомогательная функция для добавления элемента в queue
    public static void enqueue(int item) {   // вставка в конце
        // выделяем новый узел в куче
        Node node = new Node(item);
        System.out.printf("Inserting %d\n", item);

        // особый случай: queue пуста
        if (front == null) {
            // инициализируем и переднюю, и заднюю часть
            front = node;
            rear = node;
        } else {
            // обновить заднюю часть
            rear.next = node;
            rear = node;
        }
        // увеличить количество узлов на 1
        count += 1;
    }
    // Вспомогательная функция для возврата первого элемента в queue
    public static int first() {
        // проверяем наличие пустой queue
        if (front == null) {
            System.exit(-1);
        }
        return front.data;
    }

    // Вспомогательная функция для проверки, пуста ли queue или нет
    public static boolean isEmpty() {
        return rear == null && front == null;
    }

    // Функция для возврата размера queue
    private static int size() {
        return count;
    }
}