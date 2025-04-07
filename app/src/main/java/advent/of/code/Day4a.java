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
                if (horizontalMatch(wordSearch, row, col, noColumns)) {
                    found += 1;
                }
                if (verticalMatch(wordSearch, row, col, noRows)) {
                    found += 1;
                }
            }
        }

        return String.valueOf(found);
    }

    private boolean horizontalMatch(char[][] wordSearch, int row, int col, int noColumns) {
        if (col + 4 <= noColumns) {
            if (wordSearch[row][col] == 'X') {
                if (wordSearch[row][col + 1] == 'M') {
                    if (wordSearch[row][col + 2] == 'A') {
                        if (wordSearch[row][col + 3] == 'S') {
                            return true;
                        }
                    }
                }
            }
        }
        if (col >= 3) {
            if (wordSearch[row][col] == 'X') {
                if (wordSearch[row][col - 1] == 'M') {
                    if (wordSearch[row][col - 2] == 'A') {
                        if (wordSearch[row][col - 3] == 'S') {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }

    private boolean verticalMatch(char[][] wordSearch, int row, int col, int noRows) {
        if (row + 4 <= noRows) {
            if (wordSearch[row][col] == 'X') {
                if (wordSearch[row + 1][col] == 'M') {
                    if (wordSearch[row + 2][col] == 'A') {
                        if (wordSearch[row + 3][col] == 'S') {
                            return true;
                        }
                    }
                }
            }
        }
        if (row >= 3) {
            if (wordSearch[row][col] == 'X') {
                if (wordSearch[row - 1][col] == 'M') {
                    if (wordSearch[row - 2][col] == 'A') {
                        if (wordSearch[row - 3][col] == 'S') {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }

}
