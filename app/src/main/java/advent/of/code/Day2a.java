package advent.of.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day2a extends Solution {

    Day2a() {
        super.day = 2;
        super.part = "a";
    }

    String solve(List<String> puzzleInput) {

        return Long.toString(puzzleInput.stream()
            .filter(report -> isReportSafe(report))
            .collect(Collectors.counting()));
    }

    private boolean isReportSafe(String report) {
        List<Integer> levels = Arrays.stream(report.split("\\s"))
                .map(n -> Integer.parseInt(n))
                .toList();

        boolean descending = IntStream.range(0, levels.size() - 1)
                .allMatch(n -> levels.get(n) > levels.get(n + 1) &&
                    levels.get(n) - levels.get(n + 1) <= 3);

        boolean ascending = IntStream.range(0, levels.size() - 1)
                .allMatch(n -> levels.get(n) < levels.get(n + 1) &&
                    levels.get(n + 1) - levels.get(n) <= 3);

        return descending || ascending;
    }
}
