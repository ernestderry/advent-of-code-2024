package advent.of.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class Day1aTest {


    @Test
    public void listsContains1RowWithSecondItemHighest() throws IOException {

        Day1a day1a = new Day1a();

        Stream<String> puzzleInput = List.of("1    3").stream();
        assertEquals(2, day1a.calculateDistanceBetweenLists(puzzleInput));
    }

    @Test
    public void listsContains1RowWithFirstItemHighest() throws IOException {

        Day1a day1a = new Day1a();

        Stream<String> puzzleInput = List.of("3    1").stream();
        assertEquals(2, day1a.calculateDistanceBetweenLists(puzzleInput));
    }

    @Test
    public void listsContains2Rows() throws IOException {

        Day1a day1a = new Day1a();

        Stream<String> puzzleInput = List.of("3    1", "20    25").stream();
        assertEquals(7, day1a.calculateDistanceBetweenLists(puzzleInput));
    }

    @Test
    public void listsContains2RowsNotSorted() throws IOException {

        Day1a day1a = new Day1a();

        Stream<String> puzzleInput = List.of("10    5", "7    20").stream();
        assertEquals(12, day1a.calculateDistanceBetweenLists(puzzleInput));
    }

    @Test
    public void examplePuzzleInput() throws IOException {

        Day1a day1a = new Day1a();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("day1a_example.txt")) { 
            if (inputStream == null) {
                throw new FileNotFoundException("Resource file not found!");
            }

            Stream<String> puzzleInput = new BufferedReader(new InputStreamReader(inputStream)).lines(); 

            assertEquals(11, day1a.calculateDistanceBetweenLists(puzzleInput));
        } 
    }

    @Test
    public void actualPuzzleInput() throws IOException {

        Day1a day1a = new Day1a();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("day1a.txt")) { 
            if (inputStream == null) {
                throw new FileNotFoundException("Resource file not found!");
            }

            Stream<String> puzzleInput = new BufferedReader(new InputStreamReader(inputStream)).lines(); 

            assertEquals(765748, day1a.calculateDistanceBetweenLists(puzzleInput));
        } 
    }
}
