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

public class Day4aTest {

    Day4a day4a;

    @BeforeEach
    public void setup() {
        day4a = new Day4a();
    }

    @Test
    public void horizontalXmas() {
        List<String> puzzleInput = List.of(
            "..XMAS",
            "......",
            "...XMA",
            "....XM",
            ".....X",
            "......",
            "S.....",
            "AS....",
            "......",
            "MAS...",
            "XMAS..",
            ".XMAS."    
        );
        assertEquals("3", day4a.solve(puzzleInput));
    }

    @Test
    public void horizontalReverseXmas() {
        List<String> puzzleInput = List.of(
            "..SAMX",
            "......",
            "...SAM",
            "....SA",
            ".....S",
            "X.....",
            "MX....",
            "......",
            "AMX...",
            "SAMX..",
            ".SAMX."    
        );
        assertEquals("3", day4a.solve(puzzleInput));
    }

    @Test
    public void veriticalXmas() {
        List<String> puzzleInput = List.of(
            "MAS....X",
            "AS....XM",
            "S...X.MA",
            "..X.M.AS",
            ".XM.A.S.",
            "XMA.S..."
        );
        assertEquals("3", day4a.solve(puzzleInput));
    }

    @Test
    public void veriticalReverseXmas() {
        List<String> puzzleInput = List.of(
            "AMX....S",
            "MX....SA",
            "X...S.AM",
            "..S.A.MX",
            ".SA.M.X.",
            "SAM.X..."
        );
        assertEquals("3", day4a.solve(puzzleInput));
    }

    // @Test
    public void examplePuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("dayX_example.txt"); 
        assertEquals("", day4a.solve(puzzleInput));
    }

    // @Test
    public void actualPuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("dayX.txt"); 
        assertEquals("", day4a.solve(puzzleInput));
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
