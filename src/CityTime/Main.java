package CityTime;

import static java.lang.System.in;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        City moscow = new City("MOSCOW", "MOW", 3d);
        City newYork = new City("NEW YORK", "NYC", -5d);
        City london = new City("LONDON", "LON", 0d);
        City berlin = new City("BERLIN", "BER", 1d);
        City newDelhi = new City("NEW DELHI", "DEL", 5.5);

        SortedMap<String, City> cityMap = new TreeMap<>();
        cityMap.put(moscow.getCode(), moscow);
        cityMap.put(newYork.getCode(), newYork);
        cityMap.put(london.getCode(), london);
        cityMap.put(berlin.getCode(), berlin);
        cityMap.put(newDelhi.getCode(), newDelhi);

        cityMap.forEach((code, city) -> {
            System.out.println("Code : " + code + " City : " + city);
        });

        System.out.println("Enter 3 to 5 city codes from the list to see the time   :");

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Scanner scn = new Scanner(in);

        int threadCount = 0;
        while (true) {
            try {
                String key = scn.nextLine();
                City city = cityMap.get(key);
                if (city != null) {
                    executorService.execute(city);
                    threadCount ++;
                } else {
                    System.out.println("Please enter a valid city code");
                }
                if (threadCount == 5) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        executorService.shutdown();
        scn.close();
        System.exit(0);
    }
}

