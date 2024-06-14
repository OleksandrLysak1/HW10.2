package org.hw2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        List<User> users = readUsersFromFile("users.txt");

        for (User user : users) {
            System.out.println("Name: " + user.getName() + ", Age: " + user.getAge());
        }

        writeUsersToJson(users, "user.json");
    }

    public static List<User> readUsersFromFile(String fileName) {
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                users.add(new User(name, age));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static void writeUsersToJson(List<User> users, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("[\n");
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                writer.write("  {\n");
                writer.write("    \"name\": \"" + user.getName() + "\",\n");
                writer.write("    \"age\": " + user.getAge() + "\n");
                writer.write("  }");
                if (i < users.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
