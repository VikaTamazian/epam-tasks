package by.epam.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Trial> tests = new ArrayList<>();
        tests.add(new Trial("Potter", 70, 70));
        tests.add(new Trial("Weasley", 50, 60));
        tests.add(new Trial("Granger", 100, 100));
        tests.add(new LightTrial("Malfoy", 70, 80));
        tests.add(new LightTrial("Patil", 60, 50));
        tests.add(new StrongTrial("Longbottom", 80, 70));
        tests.add(new StrongTrial("Thomas", 60, 90));
        tests.add(new ExtraTrial("Finnigan", 90, 75, 75));
        tests.add(new ExtraTrial("Brown", 60, 80, 70));

        System.out.println("***** Initial trials *****");
        printTests(tests);
        System.out.println("***** Passed trials *****");
        isPassed(tests);
        System.out.println("***** Sorted by sum of marks *****");
        sortTests(tests);
        System.out.println("***** Referred students *****");
        findReferred(tests);
        System.out.println("***** All marks sums *****");
        toSumArray(tests);


    }

    private static void printTests(List<Trial> tests) {
        tests.forEach(System.out::println);
    }

    private static void isPassed(List<Trial> tests) {
        tests.stream()
                .filter(Trial::isPassed)
                .forEach(System.out::println);

    }

    private static void sortTests(List<Trial> tests) {
        tests.stream().sorted(Comparator.comparing(Trial::result)).forEach(System.out::println);

    }

    private static void findReferred(List<Trial> tests) {

        List<Trial> trials = tests.stream().map(Trial::clone).collect(Collectors.toList());

        trials
                .stream()
                .filter(Trial::isPassed)
                .map(Trial::refreshMarks)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static void toSumArray(List<Trial> tests) {
        double[] result = tests.stream().mapToDouble(Trial::result).toArray();
        Arrays.stream(result).forEach(sum -> System.out.println(sum + ";"));
    }
}
