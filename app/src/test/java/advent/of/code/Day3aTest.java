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

public class Day3aTest {

    Day3a day3a;

    @BeforeEach
    public void setup() {
        day3a = new Day3a();
    }

    @Test
    public void oneMul() {
        List<String> puzzleInput = List.of("mul(2,3)");
        assertEquals("6", day3a.solve(puzzleInput));
    }

    @Test
    public void TwoMul() {
        List<String> puzzleInput = List.of("TEXT...mul(2,3)...TEXT...mul(5,100)...TEXT");
        assertEquals("506", day3a.solve(puzzleInput));
    }

    @Test
    public void TwoLineMul() {
        List<String> puzzleInput = List.of("mul(2,3)", "mul(5,100)");
        assertEquals("506", day3a.solve(puzzleInput));
    }

    @Test
    public void examplePuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day3_example.txt"); 
        assertEquals("161", day3a.solve(puzzleInput));
    }

    @Test
    public void actualPuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day3.txt"); 
        assertEquals("175015740", day3a.solve(puzzleInput));
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
