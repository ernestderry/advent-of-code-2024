package advent.of.code;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day2b extends Solution {

    private static final int LEVEL_TOLERANCE = 3;

    Day2b() {
        super.day = 2;
        super.part = "b";
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

        boolean levelsDescendSafely;
        OptionalInt firstFailingLevel = findFirstFailingDescendingLevel(levels);
        if (firstFailingLevel.isPresent()) {
            // levels.remove(firstFailingLevel.getAsInt());
            firstFailingLevel = findFirstFailingDescendingLevel(levels);
        }
        levelsDescendSafely = !firstFailingLevel.isPresent();

        boolean levelAscendsSafely = IntStream.range(0, levels.size() - 1)
                .allMatch(n -> levelAscendsSafely(levels, n));

        return levelAscendsSafely || levelsDescendSafely;
    }

    private OptionalInt findFirstFailingDescendingLevel(List<Integer> levels) {
        return IntStream.range(0, levels.size() - 1)
                .filter(n -> !levelDescendsSafely(levels, n))
                .findFirst();
    }

    boolean levelAscendsSafely(List<Integer> levels, int n) {
        int diff = levels.get(n + 1) - levels.get(n);
        return withinAllowedTolerance(diff);
    }

    boolean levelDescendsSafely(List<Integer> levels, int n) {
        int diff = levels.get(n) - levels.get(n + 1);
        return withinAllowedTolerance(diff);
    }

    private boolean withinAllowedTolerance(int diff) {
        return diff > 0 && diff <= LEVEL_TOLERANCE;
    }
}
