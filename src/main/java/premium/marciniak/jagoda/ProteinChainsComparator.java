package premium.marciniak.jagoda;

import java.util.Arrays;

public class ProteinChainsComparator {

    public static boolean changePossible(String firstChain, String secondChain) {
        if (firstChain == null) {
            throw new IllegalArgumentException("firstChain parameter cannot be null.");
        }

        if (secondChain == null) {
            throw new IllegalArgumentException("secondChain parameter cannot be null.");
        }

        if (firstChain.length() != secondChain.length()) {
            return false;
        }

        if (firstChain.length() == 0 && secondChain.length() == 0) {
            return true;
        }

        char[] firstChainSortedChars = convertStringToSortedArrayOfChars(firstChain);
        char[] secondChainSortedChars = convertStringToSortedArrayOfChars(secondChain);

        return Arrays.equals(firstChainSortedChars, secondChainSortedChars);
    }

    private static char[] convertStringToSortedArrayOfChars(String value) {
        char[] charsArray = value.toCharArray();
        Arrays.sort(charsArray);
        return charsArray;
    }
}
