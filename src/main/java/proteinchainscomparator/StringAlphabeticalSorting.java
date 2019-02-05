package proteinchainscomparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAlphabeticalSorting {
    public static List<String> sortCharInEveryStringOnListAlphabetically(List<String> list){
        List<String> sortedList = new ArrayList<>();
        list.stream().map(String::toCharArray).forEach(string -> {
            Arrays.sort(string);
            sortedList.add(String.valueOf(string));
        });
        return sortedList;
    }
}
