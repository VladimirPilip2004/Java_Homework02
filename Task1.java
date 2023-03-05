// Задача 1. Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class Task1 {
    public static void main(String[] args) throws IOException {
        // Создаём логер
        Logger logger = Logger.getLogger(Task1.class.getName());
        FileHandler fh = new FileHandler("logTask1.txt");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        logger.info("Sort Array");
        
        // Числовой массив 
        int [] array = {15, -10, 0, -13, 1, 99, 7, 55, -25};
        printArray(array);

        // Сортируем массив и записываем в log-файл
        int[] newArr = sortArray(array, logger);
        System.out.printf("\n Результат сортировки пузырьком: \n");
        printArray(newArr);
    }
   
    // Функция печати массива
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.print(arr[arr.length-1]);
    }
    // Функция сортировки массива и записи в logTask1.txt
    public static int[] sortArray(int [] arr, Logger logger){
        for(int k = 0; k < arr.length-1; k++) {
            for (int i = 0; i < arr.length - k-1; i++){
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    logger.info(Arrays.toString(arr));
                }
            }
        }
        return arr;
    }
}