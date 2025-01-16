package advent.of.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Day2a {

    String solve(List<String> puzzleInput) {

        List<Integer> levels = Arrays.stream(puzzleInput.get(0).split("\\s"))
                .map(n -> Integer.parseInt(n))
                .toList();

        boolean descending = IntStream.range(0, levels.size() - 1)
                .allMatch(n -> levels.get(n) > levels.get(n + 1) &&
                    levels.get(n) - levels.get(n + 1) <= 3);

        boolean ascending = IntStream.range(0, levels.size() - 1)
                .allMatch(n -> levels.get(n) < levels.get(n + 1) &&
                    levels.get(n + 1) - levels.get(n) <= 3);

        return descending || ascending ? "1" : "0";
    }
}
