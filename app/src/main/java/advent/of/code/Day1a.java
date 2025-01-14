package advent.of.code;

import java.util.List;

public class Day1a extends Solution {

    Day1a() {
        super.day = 1;
        super.part = "a";
    }

    String solve(List<String> puzzleInput) {
        List<Long> list1 = puzzleInput.stream()
            .map(line -> line.trim().split("\\s+"))
            .map(pairArray -> Long.parseLong(pairArray[0]))
            .sorted()
            .toList();

        List<Long> list2 = puzzleInput.stream()
            .map(line -> line.trim().split("\\s+"))
            .map(pairArray -> Long.parseLong(pairArray[1]))
            .sorted()
            .toList();

        int numberOfRows = list1.size();
        long totalDistance = 0L;
        for (int i = 0; i < numberOfRows; i++) {
            totalDistance += Math.abs(list1.get(i) - list2.get(i));
        }            

        return Long.toString(totalDistance);
    }
}
