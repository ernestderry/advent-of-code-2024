package advent.of.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day2bTest {

    Day2b day2b;

    @BeforeEach
    public void setup() {
        day2b = new Day2b();
    }

    @Test
    public void rowWithDescendingLevelsIsSafe() {
        assertEquals("1", day2b.solve(List.of("7 6 4 2 1")));
    }

    @Test
    public void rowWithAscendingLevelsIsSafe() {
        assertEquals("1", day2b.solve(List.of("1 3 6 7 9")));
    }

    @Test
    public void rowNotAllAscendingLevelsIsNotSafe() {
        assertEquals("1", day2b.solve(List.of("1 3 2 4 5")));
    }

    @Test
    public void rowDescendingWithUnsafeLevelRemovedIsSafe() {
        assertEquals("1", day2b.solve(List.of("8 6 4 4 1")));
    }

    @Test
    public void rowAscendingUnsafeRegardlessWhichLevelIsRemoved() {
        assertEquals("0", day2b.solve(List.of("1 2 7 8 9")));
    }

    @Test
    public void rowDescendingUnsafeRegardlessWhichLevelIsRemoved() {
        assertEquals("0", day2b.solve(List.of("9 7 6 2 1")));
    }

    @Test
    public void rowAscendingWithLastLevelRemovedIsSafe() {
        assertEquals("1", day2b.solve(List.of("9 8 7 6 99")));
    }

    @Test
    public void rowDescendingWithLastLevelRemovedIsSafe() {
        assertEquals("1", day2b.solve(List.of("1 2 3 4 1")));
    }

    @Test
    public void rowAscendingWithFirstLevelRemovedIsSafe() {
        assertEquals("1", day2b.solve(List.of("99 2 3 4 5")));
    }

    @Test
    public void rowDescendingWithFirstLevelRemovedIsSafe() {
        assertEquals("1", day2b.solve(List.of("99 4 3 2 1")));
    }

    @Test
    public void examplePuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day2_example.txt"); 
        assertEquals("4", day2b.solve(puzzleInput));
    }

    public void actualPuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day2.txt"); 
        assertEquals("", day2b.solve(puzzleInput));
    }

    private List<String> readPuzzleInputFromFile(String filename) throws FileNotFoundException, IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename)) { 
            if (inputStream == null) {
                throw new FileNotFoundException("Resource file not found!");
            }
            return new BufferedReader(new InputStreamReader(inputStream)).lines().toList(); 
        }
    }
}
