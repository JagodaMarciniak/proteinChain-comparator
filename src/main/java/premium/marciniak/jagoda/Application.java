package premium.marciniak.jagoda;

import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        ApplicationArgumentParser applicationArgumentParser = new ApplicationArgumentParser();
        FileProcessor fileProcessor = new FileProcessor();

        String proteinChainsFilePath = applicationArgumentParser.getProteinChainsFilePath(args, 0);

        List<String> lines = fileProcessor.readLinesFromFile(proteinChainsFilePath);
        processProteinChains(lines);
    }

    private static void processProteinChains(List<String> proteinChains) {
        for (int i = 0; i < proteinChains.size(); i += 2) {
            String firstChain = proteinChains.get(i);
            String secondChain = proteinChains.get(i + 1);
            boolean isChangePossible = ProteinChainsComparator.changePossible(firstChain, secondChain);

            String resultMessage = createResultMessage(firstChain, secondChain, isChangePossible);
            System.out.println(resultMessage);
        }
    }

    private static String createResultMessage(String firstChain, String secondChain, boolean changeIsPossible) {
        if (changeIsPossible) {
            return String.format("%s chain can be replaced with %s chain", firstChain, secondChain);
        }
        return String.format("%s chain cannot be replaced with %s chain", firstChain, secondChain);
    }
}
