package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        for (String line : log) {
            System.out.println(line);
        }
    }

    public static List<String> filter(String file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            lines = in.lines().filter(line -> {
                String[] words = line.split(" ");
                return words[words.length - 2].equals("404");
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
}
