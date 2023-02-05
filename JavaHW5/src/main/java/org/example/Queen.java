package org.example;

import java.util.Arrays;

public class Queen {
    public static int count = 0;

    // проверка коллизии ферзей
    private static boolean isSafe(char[][] board, int row, int col) {
        // по-вертикали
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // по-диагонали \
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // по-диагонали /
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static void printSolution(char[][] board) {
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars).replaceAll(",", ""));
        }
        count++;
        System.out.println();
    }

    private static void newQueen(char[][] board, int row) {
        // Если ферзи расставленны успешно выводим результат
        if (row == board.length) {
            printSolution(board);
            return;
        }
        // ставим ферзя на каждую клетку в ряду
        for (int i = 0; i < board.length; i++) {
            // если ферзи не бьют друг друга
            if (isSafe(board, row, i)) {
                // ставим в текущую клетку
                board[row][i] = 'Q';
                // проверяем следущий ряд
                newQueen(board, row + 1);
                // удаляем ферзя с предыдущего ряда
                board[row][i] = '_';
            }
        }
    }

    public static void main(String[] args) {
        // Шахматная доска `N × N`
        int N = 8;

        char[][] board = new char[N][N];

        // инициализируем `mat[][]` с помощью `-`
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], '–');
        }

        newQueen(board, 0);
        System.out.println("Возможных комбинаций на доске размером " + N + " на " + N + " -> " + count);
    }
}