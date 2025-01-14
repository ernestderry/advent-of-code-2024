package advent.of.code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public abstract class Solution {
    String title;
    int day;

    List<String> getPuzzleInput() throws IOException {
        String filename = "day" + day + ".txt";
        List<String> puzzleInput;
        try (InputStream inputStream = App.class.getClassLoader().getResourceAsStream(filename)) { 
            if (inputStream == null) {
                throw new FileNotFoundException("Resource file not found!");
            }

            puzzleInput = new BufferedReader(new InputStreamReader(inputStream)).lines().toList(); 
        } 
        return puzzleInput;
    }

    String solve() throws IOException {
        List<String> puzzleInput = getPuzzleInput();
        return solve(puzzleInput);
    }

    abstract String solve(List<String> puzzleInput); 
}
