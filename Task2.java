package ru.vsu.cs.volobueva;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args)  {
        int yearNumber = chekCorrectTypeAndRead();

        chekCorrectNumber(yearNumber);

        checkConditionAndPrintAnswer(yearNumber);

        TypeYear result = checkConditionAndPrintAnswer(yearNumber);

        printResult(result);
    }

    static int chekCorrectTypeAndRead() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of year: yearNumber = ");

        if (!scanner.hasNextInt()) {
            System.out.print("Error: the data is incorrect");
            System.exit(0);
        }
        return scanner.nextInt();
    }

    static void chekCorrectNumber(int yearNumber) {
        if (yearNumber <= 0) {
            System.out.print("Error: the data is incorrect");
            System.exit(0);
        }
    }
    static TypeYear checkConditionAndPrintAnswer(int yearNumber) {
        if (0 == yearNumber % 4) {
            if (0 == yearNumber % 100 && 0 != yearNumber % 400) {
                return TypeYear.ORDINARY_YEAR;
            }
            else {
                return TypeYear.LEAP_YEAR;
            }
        } else {
            return TypeYear.ORDINARY_YEAR;
        }
    }

    static void printResult(TypeYear result) {
        switch (result) {
            case ORDINARY_YEAR -> System.out.println("ordinary year 365 days");
            case LEAP_YEAR -> System.out.println("leap year 366 days");
        }
    }
}