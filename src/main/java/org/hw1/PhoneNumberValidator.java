package org.hw1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class PhoneNumberValidator {

    public static void main(String[] args) {
        String fileName = "file.txt";
        printValidPhoneNumbers(fileName);
    }

    public static void printValidPhoneNumbers(String fileName) {

        String pattern1 = "^\\(\\d{3}\\) \\d{3}-\\d{4}$";
        String pattern2 = "^\\d{3}-\\d{3}-\\d{4}$";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {

                if (Pattern.matches(pattern1, line) || Pattern.matches(pattern2, line)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
