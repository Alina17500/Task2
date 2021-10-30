package ru.vsu.cs.volobueva;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        int yearNumber = chekCorrectNumberAndRead();

        checkConditionAndPrintAnswer(yearNumber);

        TypeYear result = checkConditionAndPrintAnswer(yearNumber);

        printResult(result);
    }

    static int chekCorrectNumberAndRead() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of year: yearNumber = ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Error: the data is incorrect. Read the condition again and try again:");
            return chekCorrectNumberAndRead();
        }
        return number;
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