package advent.of.code;

import java.util.List;
import java.util.stream.Stream;

public class Day1a {

    double calculateDistanceBetweenLists(Stream<String> puzzleInput) {
        List<String[]> fred = puzzleInput
            .map(line -> line.trim().split("\\s+"))
            .toList();

        System.out.println(fred.get(0)[0]);
        System.out.println(fred.get(0)[1]);
        return Math.abs(Double.parseDouble(fred.get(0)[1]) - Double.parseDouble(fred.get(0)[0]));
    }
}
