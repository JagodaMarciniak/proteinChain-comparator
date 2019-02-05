package proteinchainscomparator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessor {

    public List<String> readLinesFromFile(String filepath) throws FileNotFoundException {
        if (filepath == null) {
            throw new IllegalArgumentException("Filepath cannot be null.");
        }
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filepath));
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();
        return lines;
    }
    public void writeLinesToFile(List<String> lines, String filepath) throws IOException {
        if (filepath == null) {
            throw new IllegalArgumentException("Filepath cannot be null.");
        }
        if (lines == null) {
            throw new IllegalArgumentException("Lines cannot be null.");
        }
        PrintWriter printWriter = new PrintWriter(new FileWriter(filepath));
        for (String line : lines) {
            printWriter.println(line);
        }
        printWriter.close();
    }
}
