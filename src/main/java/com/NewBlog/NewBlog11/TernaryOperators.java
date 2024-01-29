package com.NewBlog.NewBlog11;

public class TernaryOperators {

    public static void main(String[] args) {

        int age = 25;
        String message = (age >= 20) ? "Adult" : "Minor";
        System.out.println(message);

        int[] numbers = {10, 20, 45, 30, 88};
        for (int num : numbers) {
            String message2 = (num % 2 == 0) ? "Even" : "Odd";
            System.out.println(num + "is" + message2);

        }
    }
}