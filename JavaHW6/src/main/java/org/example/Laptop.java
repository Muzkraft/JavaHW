package org.example;
/*Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии)
фильтрации и выведет ноутбуки, отвечающие фильтру.
Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.*/

public class Laptop {
    String vendor;
    int ram;
    int hdd;
    String os;
    String color;


    public Laptop(String vendor, int ram, int hdd, String os, String color) {
        this.vendor = vendor;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Laptop)) {
            return false;
        }
        Laptop laptop = (Laptop) obj;
        if (vendor.equals(laptop.vendor) && ram == laptop.ram && hdd == laptop.hdd && os.equals(laptop.os) && color.equals(laptop.color)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return vendor.hashCode() + ram + hdd + os.hashCode() + color.hashCode();
    }

    @Override
    public String toString() {
        return "\n Производитель: " + vendor +
                "\n Оперативная память: " + ram +
                "\n Жесткий диск: " + hdd +
                "\n ОС: " + os +
                "\n Цвет: " + color + "\n\n";
    }
}
