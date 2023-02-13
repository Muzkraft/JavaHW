package org.example;

import java.util.*;

public class Operation {
    private static Scanner scanner = new Scanner(System.in);

    static Map<Integer, String> criterionMap() {
        Map<Integer, String> criterion =new HashMap<>();
        criterion.put(1, "Поиск по производителю");
        criterion.put(2, "Поиск по объему ОЗУ");
        criterion.put(3, "Поиск по объему ПЗУ");
        criterion.put(4, "Поиск по ОС");
        criterion.put(5, "Поиск по цвету");
        criterion.put(6, "Все предложения");
        criterion.put(7, "Выход");
        return criterion;
    }

    static Map<Integer, Laptop> laptopMap() {
        Random rnd = new Random();
        String[] vendArr = new String[] {"Lenovo", "Asus", "Apple", "Xiaomi"};
        String[] colArr = new String[] {"Red", "Blue", "Black", "White", "Steel"};
        String[] osArr = new String[] {"Linux", "MacOS", "Windows"};
        Integer[] ramArr = new Integer[] {8, 16, 32, 64, 128, 256};
        Integer[] hddArr = new Integer[] {64, 80, 128, 256, 512, 1000, 2000, 3000};

        Map<Integer, Laptop> laptopMap = new HashMap<>();

        for (int i = 0; i < 20; i++) {
            Laptop  laptop = new Laptop
                    (vendArr[rnd.nextInt(vendArr.length)],
                            ramArr[rnd.nextInt(ramArr.length)],
                            hddArr[rnd.nextInt(hddArr.length)],
                            osArr[rnd.nextInt(osArr.length)],
                            colArr[rnd.nextInt(colArr.length)]);
            laptopMap.put(i, laptop);
        }
        return laptopMap;
    }
    static Set<Laptop> laptopByRam(int ram) {
        Set<Laptop> byRam = new HashSet<>();
        for (Map.Entry<Integer, Laptop> entry: laptopMap().entrySet()) {
            Laptop laptop = entry.getValue();
            if (laptop.ram >= ram){
                byRam.add(laptop);
            }
        }
        return byRam;
    }
    static Set<Laptop> laptopByHdd(int hdd) {
        Set<Laptop> byHdd = new HashSet<>();
        for (Map.Entry<Integer, Laptop> entry: laptopMap().entrySet()) {
            Laptop laptop = entry.getValue();
            if (laptop.hdd >= hdd){
                byHdd.add(laptop);
            }
        }
        return byHdd;
    }
    static Set<Laptop> laptopByOs(String os) {
        Set<Laptop> byOs = new HashSet<>();
        for (Map.Entry<Integer, Laptop> entry: laptopMap().entrySet()) {
            Laptop laptop = entry.getValue();
            if (os.equals(laptop.os)) {
                byOs.add(laptop);
            }
        }
        return byOs;
    }
    static Set<Laptop> laptopByVendor(String vendor) {
        Set<Laptop> byVendor = new HashSet<>();
        for (Map.Entry<Integer, Laptop> entry: laptopMap().entrySet()) {
            Laptop laptop = entry.getValue();
            if (vendor.equals(laptop.vendor)) {
                byVendor.add(laptop);
            }
        }
        return byVendor;
    }
    static Set<Laptop> laptopByColor(String color) {
        Set<Laptop> byColor = new HashSet<>();
        for (Map.Entry<Integer, Laptop> entry: laptopMap().entrySet()) {
            Laptop laptop = entry.getValue();
            if (color.equals(laptop.color)) {
                byColor.add(laptop);
            }
        }
        return byColor;
    }
    static void operation(int choice) {

        switch (choice) {
            case 1:
                System.out.print("Введите значение: ");
                String vendor = scanner.nextLine();
                System.out.println(laptopByVendor(vendor));
                break;
            case 2:
                System.out.print("Введите значение: ");
                int ram = scanner.nextInt();
                System.out.println(laptopByRam(ram));
                break;
            case 3:
                System.out.print("Введите значение: ");
                int hdd = scanner.nextInt();
                System.out.println(laptopByHdd(hdd));
                scanner.close();
                break;
            case 4:
                System.out.print("Введите значение: ");
                String os = scanner.nextLine();
                System.out.println(laptopByOs(os));
                scanner.close();
                break;
            case 5:
                System.out.print("Введите значение: ");
                String color = scanner.nextLine();
                System.out.println(laptopByColor(color));
                scanner.close();
                break;
            case 6:
                System.out.println(Operation.laptopMap());
                break;
            default: break;
        }
    }
}
