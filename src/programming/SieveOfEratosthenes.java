package programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SieveOfEratosthenes {

    public static IntStream primeStream(final int limit) {
        final ArrayList<Integer> primes = new ArrayList<>();
        IntStream primesThreeToLimit =
                IntStream.iterate(3, i -> i <= limit, i -> i + 2)
                        .filter(i -> {
//                            System.out.println(primes);
                            final int testUntil = (int) Math.sqrt(limit);
                            for(Integer p: primes) {
//                                System.out.println(i + " " +  p);
                                if(i % p == 0) return false;
                                if(p > testUntil) break;
                            }
                            primes.add(i);
                            return true;
                        });
        return IntStream.concat(IntStream.of(1, 2), primesThreeToLimit);
    }

    private static boolean isPrime(int n) {
        int root = (int) Math.sqrt(n);
        return IntStream
                .rangeClosed(2, root)
                .noneMatch(div -> n%div == 0);
    }
    private static List<Integer> primes(int max) {
        return IntStream
                .range(2, max)
                .filter(SieveOfEratosthenes::isPrime)
                .collect(ArrayList::new,
                         ArrayList::add,
                         ArrayList::addAll);
    }

    private static boolean isPrimeOpt(List<Integer> primes, int n) {
        int root = (int) Math.sqrt(n);
        return takeWhile(primes, root)
                .stream()
                .noneMatch(div -> n%div == 0);
    }

    private static List<Integer> takeWhile(List<Integer> src, int max) {
        int i;
        for(i = 0; i < src.size() && src.get(i) <= max; i++) {}
        return src.subList(0, i);
    }

    private static List<Integer> primesOpt(int max) {
        ArrayList<Integer> res = new ArrayList<>();
//        res.add(Integer.valueOf(1));
        return IntStream
                .range(2, max)
                .filter(n -> SieveOfEratosthenes.isPrimeOpt(res, n))
                .collect(() -> res, ArrayList::add, (l1, l2) -> {});
    }

    public static void main(String[] args) {
        System.out.println("Using primeStream");
        System.out.println(Arrays.toString(primeStream(1000).toArray()));
        System.out.println("Using primesOpt");
        System.out.println(primesOpt(1000));
        System.out.println("Using primes");
        System.out.println(primes(1000));
    }


}
