package advent.of.code;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3b extends Solution {

    Day3b() {
        super.day = 3;
        super.part = "b";
    }

    String solve(List<String> puzzleInput) {
        return solveWithLoops(puzzleInput);
    }

    String solveWithLoops(List<String> puzzleInput) {
        
        long total = 0;
        boolean multiplicationEnabled = true;
        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don\'t\\(\\)");

        for (String line : puzzleInput) {
            Matcher matcher = pattern.matcher(line);
        
            while (matcher.find()) {
                if (matcher.group(0).equals("don't()")) {
                    multiplicationEnabled = false;
                    continue;
                }
                if (matcher.group(0).equals("do()")) {
                    multiplicationEnabled = true;
                    continue;
                }
                if (multiplicationEnabled) {
                    total += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
                }
            }
        }
        return Long.toString(total);
    }
}
