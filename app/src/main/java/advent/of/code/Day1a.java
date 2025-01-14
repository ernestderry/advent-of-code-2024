package advent.of.code;

import java.util.List;

public class Day1a extends Solution {

    Day1a() {
        super.day = 1;
        super.title = "Day 1a";
    }

    String solve(List<String> puzzleInput) {
        List<Double> list1 = puzzleInput.stream()
            .map(line -> line.trim().split("\\s+"))
            .map(pairArray -> Double.parseDouble(pairArray[0]))
            .sorted()
            .toList();

        List<Double> list2 = puzzleInput.stream()
            .map(line -> line.trim().split("\\s+"))
            .map(pairArray -> Double.parseDouble(pairArray[1]))
            .sorted()
            .toList();

        int numberOfRows = list1.size();
        int totalDistance = 0;
        for (int i = 0; i < numberOfRows; i++) {
            totalDistance += Math.abs(list1.get(i) - list2.get(i));
        }            
        
        return Integer.toString(totalDistance);
    }
}
