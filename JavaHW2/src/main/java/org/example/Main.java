package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        parser();
        fileWriter();
        bubbleSort();
        logger.info("ok");

    }
    static StringBuilder parser() {
        File file = new File("SchoolClass.txt");
        StringBuilder stringBuilder = new StringBuilder();
        String json = "";

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                json = scanner.nextLine();
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage(), e);
            e.printStackTrace();
        }

        json = json.substring(3, json.length() - 3);
        json = json.replace("\"", "");
        String[] students = json.split("},");
        String res = "";

        for (int i = 0; i < students.length; i++) {
            String[] data = students[i].split(",");
            for (int j = 0; j < data.length; j++) {
                data[j] = data[j].replace(":", "");
                data[j] = data[j].replace(",", "");
                data[j] = data[j].replace("{", "");
                data[j] = data[j].replace("фамилия", "");
                data[j] = data[j].replace("оценка", "");
                data[j] = data[j].replace("предмет", "");
            }
            res += "Студент" + data[0] + " получил оценку" + data[1] + " по предмету" + data[2] + ".\n";
        }
        return stringBuilder.append(res);
    }
    static void fileWriter() {
        try (FileWriter fileWriter = new FileWriter("itogi.txt", false)) {
            fileWriter.write(parser().toString());
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
            e.printStackTrace();
        }
    }
    static void bubbleSort() {
        int[] arr = new int[]{4, 3, 1, 2, 98, 7, 4, 5, 0, 20};
        System.out.println(Arrays.toString(arr));
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp =arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
            logger.log(Level.INFO, Arrays.toString(arr));
        }
    }
    static {
        SimpleFormatter formatter = new SimpleFormatter();
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("log.txt", true);
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage(), e);
            e.printStackTrace();
        }
    }
}