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

public class Day2aTest {

    Day2a day2a;

    @BeforeEach
    public void setup() {
        day2a = new Day2a();
    }

    @Test
    public void rowWithDescendingLevelsIsSafe() {
        assertEquals("1", day2a.solve(List.of("7 6 4 2 1")));
    }

    @Test
    public void rowWithAscendingLevelsIsSafe() {
        assertEquals("1", day2a.solve(List.of("1 3 6 7 9")));
    }

    @Test
    public void rowNotAllAscendingDescendingLevelsIsNotSafe() {
        assertEquals("0", day2a.solve(List.of("1 3 2 4 5")));
    }

    @Test
    public void rowWith2EqualAdjacentLevelsIsNotSafe() {
        assertEquals("0", day2a.solve(List.of("8 6 4 4 1")));
    }

    @Test
    public void rowWhereAscendingAdjacentLevelsDifferByMoreThan3IsNotSafe() {
        assertEquals("0", day2a.solve(List.of("1 2 7 8 9")));
    }

    @Test
    public void rowWhereDescendingAdjacentLevelsDifferByMoreThan3IsNotSafe() {
        assertEquals("0", day2a.solve(List.of("9 7 6 2 1")));
    }

    public void examplePuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day2_example.txt"); 
        assertEquals("2", day2a.solve(puzzleInput));
    }

    // public void actualPuzzleInput() throws IOException {
    //     List<String> puzzleInput = readPuzzleInputFromFile("day2.txt"); 
    //     assertEquals("", day2a.solve(puzzleInput));
    // }

    private List<String> readPuzzleInputFromFile(String filename) throws FileNotFoundException, IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename)) { 
            if (inputStream == null) {
                throw new FileNotFoundException("Resource file not found!");
            }
            return new BufferedReader(new InputStreamReader(inputStream)).lines().toList(); 
        }
    }
}
