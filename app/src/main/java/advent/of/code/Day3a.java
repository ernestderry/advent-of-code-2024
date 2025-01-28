package advent.of.code;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3a extends Solution {

    Day3a() {
        super.day = 3;
        super.part = "a";
    }

    String solve(List<String> puzzleInput) {
        // return solveWithLoops(puzzleInput);
        return solveWithStreams(puzzleInput);
    }

    String solveWithStreams(List<String> puzzleInput) {
        
        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        
        return Long.toString(puzzleInput.stream()
            .flatMap(line -> pattern.matcher(line).results())
            .map(r -> Integer.parseInt(r.group(1)) * Integer.parseInt(r.group(2)))
            .reduce(0, Integer::sum));
    }


    String solveWithLoops(List<String> puzzleInput) {
        
        long total = 0;
        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");

        for (String line : puzzleInput) {
            Matcher matcher = pattern.matcher(line);
        
            while (matcher.find()) {
                total += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
            }
        }
        return Long.toString(total);
    }
}
