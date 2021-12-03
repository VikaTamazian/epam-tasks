package by.epam.lab.inheritance.Task0;

import static by.epam.lab.inheritance.Task0.Trial.PASS_MARK;

public class Runner {
    private static final double VALUE = PASS_MARK * 0.5;

    public static void main(String[] args) {
        Trial[] trials = {
                new Trial("Sakovich", 45, 93),
                new Trial("Zhylinsky", 51, 35),
                new Trial("Fomin", 70, 20),
                new LiteTrial("Barkou", 29, 95),
                new LiteTrial("Lis", 35, 68),
                new StrongTrial("Astapenka", 90, 57),
                new StrongTrial("Koval", 68, 80),
                new ExtraTrial("Avdeev", 77, 89, 70),
                new ExtraTrial("Ignatov", 68, 55, 70)

        };

        Utils.printTrials(trials);

        for (Trial trial : trials) {
            if (trial.findArithmeticMeanValue() < VALUE) {
                System.out.println(trial);
            }

        }

        for (Trial trial : trials) {
            if (!trial.isPassed()) {
                trial.refreshMarks();
            }
        }

        Utils.printTrials(trials);

        Trial entityTrial = new Trial(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        for (Trial trial : trials) {
            if (trial.equals(entityTrial) && trial.getClass() == Trial.class) {
                System.out.println(trial);
            }
        }

    }


}
