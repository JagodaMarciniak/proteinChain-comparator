//created by Jagoda Marciniak 14.10.2018
package proteinchainscomparator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProteinChainComparator {

    public static void main(String[] args) throws IOException {
        FileProcessor fileProcessor = new FileProcessor();
        List<String> proteinChainsToSort = fileProcessor.readLinesFromFile("src/main/resources/dane.txt");
        List<String> answer = compareProteinChainAndGetAnswer(proteinChainsToSort);
        fileProcessor.writeLinesToFile(answer, "src/main/resources/answer.txt");
    }

    private static List<String> compareProteinChainAndGetAnswer(List<String> proteinChainsToSort)  {
        List<String> sortedProteinChains = StringAlphabeticalSorting.sortCharInEveryStringOnListAlphabetically(proteinChainsToSort);
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < sortedProteinChains.size(); i += 2) {
            String firstChain = sortedProteinChains.get(i);
            String secondChain = sortedProteinChains.get(i + 1);
            boolean isPossible = changePossible(firstChain,secondChain);
            String isPossibleMessage = createResultMessage(firstChain,secondChain,isPossible);
            answer.add(isPossibleMessage);
            System.out.println(isPossibleMessage);
        }
        return answer;
    }

    private static boolean changePossible(String firstChain, String secondChain) {
        if (firstChain == null) {
            throw new IllegalArgumentException("firstChain parameter cannot be null.");
        }
        if (secondChain == null) {
            throw new IllegalArgumentException("secondChain parameter cannot be null.");
        }
        if (firstChain.length() != secondChain.length()) {
            return false;
        }
        return firstChain.equals(secondChain);
    }

    private static String createResultMessage(String firstChain, String secondChain, boolean changeIsPossible) {
        if (changeIsPossible) {
            return String.format("%s chain can be replaced with %s chain", firstChain, secondChain);
        }
        return String.format("%s chain cannot be replaced with %s chain", firstChain, secondChain);
    }
}
