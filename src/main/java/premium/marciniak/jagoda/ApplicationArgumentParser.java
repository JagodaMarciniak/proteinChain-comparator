package premium.marciniak.jagoda;

import java.io.File;

public class ApplicationArgumentParser {

    public String getProteinChainsFilePath(String[] args, int expectedPositionOfArgument) {
        if (args == null || args[expectedPositionOfArgument].length() == 0) {
            throw new IllegalArgumentException("File path cannot be null or empty.");
        }

        File file = new File(args[expectedPositionOfArgument]);
        if (!file.isFile()) {
            throw new IllegalArgumentException("Passed argument is invalid file path.");
        }

        return args[expectedPositionOfArgument];
    }
}
