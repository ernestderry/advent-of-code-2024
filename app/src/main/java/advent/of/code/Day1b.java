package advent.of.code;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day1b extends Solution {

    Day1b() {
        super.day = 1;
        super.part = "b";
    }

    public String solve(List<String> puzzleInput) {

        List<Long> list1 = puzzleInput.stream()
            .map(line -> line.trim().split("\\s+"))
            .map(pairArray -> Long.parseLong(pairArray[0]))
            .sorted()
            .toList();

        Map<Long, Long> list2EntryCounts = puzzleInput.stream()
            .map(line -> line.trim().split("\\s+"))
            .map(pairArray -> Long.parseLong(pairArray[1]))
            .collect(Collectors.groupingBy(id -> id, Collectors.counting()));

        return Long.toString(list1.stream()
            .mapToLong(id -> id * Optional.ofNullable(list2EntryCounts.get(id)).orElse(0L))
            .sum());            
    }
}
