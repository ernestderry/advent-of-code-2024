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

public class Day1aTest {

    Day1a day1a;

    @BeforeEach
    public void setup() {
        day1a = new Day1a();
    }

    @Test
    public void listsContains1RowWithSecondListHighest() throws IOException {
        List<String> puzzleInput = List.of("1    3");
        assertEquals("2", day1a.solve(puzzleInput));
    }

    @Test
    public void listsContains1RowWithFirstListHighest() throws IOException {
        List<String> puzzleInput = List.of("3    1");
        assertEquals("2", day1a.solve(puzzleInput));
    }

    @Test
    public void listsContains2Rows() throws IOException {
        List<String> puzzleInput = List.of("3    1", "20    25");
        assertEquals("7", day1a.solve(puzzleInput));
    }

    @Test
    public void listsContains2RowsNotSorted() throws IOException {
        List<String> puzzleInput = List.of("10    5", "7    20");
        assertEquals("12", day1a.solve(puzzleInput));
    }

    @Test
    public void examplePuzzleInput() throws IOException {

        List<String> puzzleInput = readPuzzleInputFromFile("day1_example.txt"); 
        assertEquals("11", day1a.solve(puzzleInput));
    }

    @Test
    public void actualPuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day1.txt"); 
        assertEquals("765748", day1a.solve(puzzleInput));
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
