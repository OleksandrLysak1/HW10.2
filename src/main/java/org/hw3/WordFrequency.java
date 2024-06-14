package org.hw3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class WordFrequencyCounter {

    public static void main(String[] args) {
        String fileName = "words.txt";
        Map<String, Integer> wordFrequency = countWordFrequency(fileName);

        List<Map.Entry<String, Integer>> sortedEntries = wordFrequency.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toList());

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static Map<String, Integer> countWordFrequency(String fileName) {
        Map<String, Integer> wordFrequency = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordFrequency;
    }
}
