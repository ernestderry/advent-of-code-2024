package advent.of.code;

import java.util.List;

public class Day4a extends Solution {

    Day4a() {
        super.day = 0;
        super.part = "a";
    }

    String solve(List<String> puzzleInput) {

        char[][] wordSearch = puzzleInput.stream()
            .map(String::toCharArray)
            .toArray(char[][]::new);

        int noRows = wordSearch.length;
        int noColumns = wordSearch[0].length;
        int found = 0;

        for (int row = 0; row < noRows; row++) {
            for (int col = 0; col < noColumns; col++) {
                if (col + 4 <= noColumns) {
                if (wordSearch[row][col] == 'X') {
                        if (wordSearch[row][col + 1] == 'M') {
                            if (wordSearch[row][col + 2] == 'A') {
                                if (wordSearch[row][col + 3] == 'S') {
                                    found += 1;
                                }
                            }
                        }
                    }
                }
            }
        }

        return String.valueOf(found);
    }
}
