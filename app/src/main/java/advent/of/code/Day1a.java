package advent.of.code;

import java.util.List;
import java.util.stream.Stream;

public class Day1a {

    double calculateDistanceBetweenLists(Stream<String> puzzleInputStream) {
        List<String> puzzleInput = puzzleInputStream.toList();
        List<Double> list1 = puzzleInput.stream()
            .map(line -> line.trim().split("\\s+"))
            .map(pairArray -> Double.parseDouble(pairArray[0]))
            .toList();

        List<Double> list2 = puzzleInput.stream()
            .map(line -> line.trim().split("\\s+"))
            .map(pairArray -> Double.parseDouble(pairArray[1]))
            .toList();


        int numberOfRows = list1.size();
        int totalDistance = 0;
        for (int i = 0; i < numberOfRows; i++) {
            totalDistance += Math.abs(list1.get(i) - list2.get(i));
        }            
        return totalDistance;
    }
}
