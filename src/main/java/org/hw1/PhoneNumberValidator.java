package org.hw1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class PhoneNumberValidator {

    private static final Pattern pattern1 = Pattern.compile("^\\(\\d{3}\\) \\d{3}-\\d{4}$");
    private static final Pattern pattern2 = Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$");

    public static void main(String[] args) {
        String fileName = "file.txt";
        printValidPhoneNumbers(fileName);
    }

    public static void printValidPhoneNumbers(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (pattern1.matcher(line).matches() || pattern2.matcher(line).matches()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
