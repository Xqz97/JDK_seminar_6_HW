import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.*;

public class MontyHallSimulation {

    public static void main(String[] args) {
        int totalGames = 1000;
        int switchWins = 0;
        int stayWins = 0;

        DescriptiveStatistics statistics = new DescriptiveStatistics();
        HashMap<Integer, String> ttlStatus = new HashMap<>(totalGames);

        for (int i = 0; i < totalGames; i++) {
            ArrayList<String> gameStory = new ArrayList<>();
            Random rnd = new Random();
            int carPosition = rnd.nextInt(3);
            int openChoice = rnd.nextInt(3);

            int isGoat;
            do {
                isGoat = rnd.nextInt(3);
            } while (isGoat == carPosition || isGoat == openChoice);

            int finalChoice;
            do {
                finalChoice = rnd.nextInt(3);
            } while (finalChoice == openChoice || finalChoice == isGoat);

            if (finalChoice == carPosition) {
                switchWins++;
                gameStory.add("Поражение");
                statistics.addValue(switchWins);
                ttlStatus.put(i, "Поражение");
            } else if (openChoice == carPosition) {
                stayWins++;
                gameStory.add("УСПЕХ!");
                statistics.addValue(stayWins);
                ttlStatus.put(i, "УСПЕХ!");
            }
            System.out.println(gameStory);
        }

        System.out.println("Поражений: " + switchWins);
        System.out.println("Побед: " + stayWins);
        System.out.println("Max " + statistics.getMax());
        System.out.println(ttlStatus);

        // Визуализация статистики игр
        System.out.println("Визуализация статистики:");
        System.out.println("************************");
        System.out.println("Процент побед после смены выбора: " + ((double) switchWins / totalGames) * 100 + "%");
        System.out.println("Процент побед без смены выбора: " + ((double) stayWins / totalGames) * 100 + "%");
    }
}