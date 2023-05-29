package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVReader {

    public static List<String> readData(String csvFileName) throws IOException {
        //src/test/resources/Data.csv
        List<String> allLines = Files.readAllLines(Paths.get(csvFileName));
        return allLines;
    }

}
