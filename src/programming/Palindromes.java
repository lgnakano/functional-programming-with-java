package programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Palindromes {

//    public static <A, B, Pair> List<Pair<A, B>> zipJava8(List<A> as, List<B> bs) {
//        return IntStream.range(0, Math.min(as.size(), bs.size()))
//                .mapToObj(i -> new Pair<>(as.get(i), bs.get(i)))
//                .collect(Collectors.toList());
//    }

    public static <A, B> List<Map.Entry<A, B>> zipJava8(List<A> as, List<B> bs) {
        return IntStream.range(0, Math.min(as.size(), bs.size()))
                .mapToObj(i -> Map.entry(as.get(i), bs.get(i)))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                .collect(Collectors.toList());
    }

    /**
     *
     * @param s - input string
     * @return string with characters sorted
     */
    private static String transform(String s) {
        return s.chars()
                .sorted()
                .collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

    /**
     *
     * @param inputStrings - List of strings
     * @return map of transformed string to all palindromes on input string
     */
    private static Map<String, List<String>> getPalindromeMap(List<String> inputStrings) {
        return inputStrings.stream()
                .collect(Collectors.groupingBy(Palindromes::transform));
    }
    /**
     *
     * @param inputStrings - List of strings
     * @return mapping from transformed string to all palindromes
     * present on the input strings that have more than one palindrome.
     */
    private static Map<String, List<String>> getPalindromesMapFiltered(List<String> inputStrings) {
        return getPalindromeMap(inputStrings)
                .entrySet()
                .stream()
                .filter(map -> map.getValue().size() >= 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     *
     * @param inputStrings - input strings
     * @return List of Lists of Strings where each list has all
     * strings on the inputStrings that are palindromes of the string
     * on that particular position on the list.
     */
    private static List<List<String>> findPalindromesList(List<String> inputStrings) {
        return inputStrings.stream()
                .map(
                        s -> getPalindromesMapFiltered(inputStrings)
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
        System.out.println("Input: " + inputStrings);

        System.out.println(findPalindromesList(inputStrings));

        System.out.println(zipJava8(inputStrings, findPalindromesList(inputStrings)));

//        findPalindromesList(inputStrings)
//                .forEach(System.out::println);
    }


}
