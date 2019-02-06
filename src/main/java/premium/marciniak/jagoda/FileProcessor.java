package premium.marciniak.jagoda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    public List<String> readLinesFromFile(String filePath) throws IOException {
        if (filePath == null) {
            throw new IllegalArgumentException("filePath parameter cannot be null.");
        }

        List<String> linesFromFile = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        for (String line; (line = bufferedReader.readLine()) != null; ) {
            linesFromFile.add(line);
        }

        return linesFromFile;
    }
}
