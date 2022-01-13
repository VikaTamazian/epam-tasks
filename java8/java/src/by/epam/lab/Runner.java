package by.epam.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Trial> tests = new ArrayList<>(Arrays.asList(
                new Trial("Potter", 70, 70),
                new Trial("Weasley", 50, 60),
                new Trial("Granger", 100, 100),
                new LightTrial("Malfoy", 70, 80),
                new LightTrial("Patil", 60, 50),
                new StrongTrial("Longbottom", 80, 70),
                new StrongTrial("Thomas", 60, 90),
                new ExtraTrial("Finnigan", 90, 75, 75),
                new ExtraTrial("Brown", 60, 80, 70)
        ));


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
        System.out.println(tests.stream()
                .filter(Trial::isPassed)
                .count());
    }

    private static void sortTests(List<Trial> tests) {
        tests.stream()
                .sorted(Comparator.comparing(Trial::result))
                .forEach(System.out::println);

    }

    private static void findReferred(List<Trial> tests) {

        List<Trial> trials = tests.stream()
                .map(Trial::clone)
                .collect(Collectors.toList());

        trials
                .stream()
                .filter(Trial::isPassed)
                .map(Trial::refreshMarks)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static void toSumArray(List<Trial> tests) {
        double[] result = tests.stream()
                .mapToDouble(Trial::result)
                .toArray();
        String collect = Arrays.stream(result)
                .sorted()
                .mapToObj(Double::toString).collect(Collectors.joining(";"));
        System.out.println(collect);

    }
}
