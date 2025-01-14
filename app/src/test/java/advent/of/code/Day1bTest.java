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

public class Day1bTest {

    Day1b day1b;

    @BeforeEach
    public void setup() {
        day1b = new Day1b();
    }

    @Test
    public void itemInFirstListNotInSecondList() {
        List<String> puzzleInput = List.of("1    3");
        assertEquals("0", day1b.solve(puzzleInput));
    }
    
    @Test
    public void itemInFirstListIsInSecondList() {
        List<String> puzzleInput = List.of("3    3");
        assertEquals("3", day1b.solve(puzzleInput));
    }

    @Test
    public void itemInFirstListIsInSecondListMoreThanOnce() {
        List<String> puzzleInput = List.of("3    3", "1    3");
        assertEquals("6", day1b.solve(puzzleInput));
    }

    @Test
    public void sumsAllLineScoresFromFirstListAgainstCountsInSecondList() {
        List<String> puzzleInput = List.of("3    3", "2    3", "1    2");
        assertEquals("8", day1b.solve(puzzleInput));
    }

    @Test
    public void examplePuzzleInput() throws IOException {

        List<String> puzzleInput = readPuzzleInputFromFile("day1_example.txt"); 
        assertEquals("31", day1b.solve(puzzleInput));
    }

    @Test
    public void actualPuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day1.txt"); 
        assertEquals("27732508", day1b.solve(puzzleInput));
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
