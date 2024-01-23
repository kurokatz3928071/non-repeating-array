/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.nonrepeatingarray;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Aspire S7
 */
public class Nonrepeatingarray {

    public static void main(String[] args) {
        int arraySize = 10; 
        char[] letters = generateNonRepeatingLettersArray(arraySize);

        System.out.println("Generated Array: " + Arrays.toString(letters));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the letter to search: ");
        char letterToSearch = scanner.next().charAt(0);

        int index = linearSearch(letters, letterToSearch);

        if (index != -1) {
            System.out.println("Letter found at index: " + index);
        } else {
            System.out.println("Letter not found in the array.");
        }

        scanner.close();
    }

    private static char[] generateNonRepeatingLettersArray(int size) {
        char[] array = new char[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            char randomLetter;
            do {
                randomLetter = (char) (random.nextInt(26) + 'a'); 
            } while (contains(array, i, randomLetter));

            array[i] = randomLetter;
        }

        return array;
    }

    private static boolean contains(char[] array, int end, char value) {
        for (int i = 0; i < end; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    private static int linearSearch(char[] array, char target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; 
            }
        }
        return -1; 
    }
}