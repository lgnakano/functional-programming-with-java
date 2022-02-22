package programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Palindromes {

    private static String transform(String s) {
        return s.chars()
                .sorted()
                .collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

    private static Map<String, List<String>> getPalindromesMap(List<String> inputStrings) {
        return inputStrings.stream()
                .collect(Collectors.groupingBy(Palindromes::transform))
                .entrySet()
                .stream()
                .filter(map -> map.getValue().size() >= 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static List<List<String>> findPalindromes(List<String> inputStrings) {
        return inputStrings.stream()
                .map(
                        s -> getPalindromesMap(inputStrings)
                                .getOrDefault(transform(s), new ArrayList<>())
                                .stream()
                                .filter( l -> s.compareTo(l) != 0)
                                .collect( Collectors.toList())
                )
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {

        var inputStrings = List.of(
                "aab", "aac", "baa", "aad", "eco", "coe", "aba"
        );

        System.out.println(findPalindromes(inputStrings));
    }


}
