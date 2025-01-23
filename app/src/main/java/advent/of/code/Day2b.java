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
            .filter(report -> isReportSafe2(report))
            .collect(Collectors.counting()));

    }

    private boolean isReportSafe2(String report) {
        
        boolean reportIsSafe;
        
        List<Integer> levels = Arrays.stream(report.split("\\s"))
            .map(n -> Integer.parseInt(n))
            .collect(Collectors.toList());
  
        boolean levelsDescendSafely = IntStream.range(1, levels.size())
            .allMatch(n -> levelDescendsSafely(levels, n));

        boolean levelAscendsSafely = IntStream.range(1, levels.size())
            .allMatch(n -> levelAscendsSafely(levels, n));

        reportIsSafe = levelAscendsSafely || levelsDescendSafely;

        if (!reportIsSafe) {
            for (int m = 0; m < levels.size() && !reportIsSafe; m++) {
                List<Integer> modifiedLevels = Arrays.stream(report.split("\\s"))
                    .map(n -> Integer.parseInt(n))
                    .collect(Collectors.toList());
                modifiedLevels.remove(m);

                levelsDescendSafely = IntStream.range(1, modifiedLevels.size())
                    .allMatch(n -> levelDescendsSafely(modifiedLevels, n));
    
                levelAscendsSafely = IntStream.range(1, modifiedLevels.size())
                    .allMatch(n -> levelAscendsSafely(modifiedLevels, n));
    
                reportIsSafe = levelAscendsSafely || levelsDescendSafely;
            }
        }

        return reportIsSafe;
    }

    boolean levelAscendsSafely(List<Integer> levels, int n) {
        int diff = levels.get(n) - levels.get(n - 1);
        return withinAllowedTolerance(diff);
    }

    boolean levelDescendsSafely(List<Integer> levels, int n) {
        int diff = levels.get(n - 1) - levels.get(n);
        return withinAllowedTolerance(diff);
    }

    private boolean withinAllowedTolerance(int diff) {
        return diff > 0 && diff <= LEVEL_TOLERANCE;
    }
}
