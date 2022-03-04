package programming;

import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class ReverseSkipList {

    public static void main(String[] args) {

        List<String> input = List.of("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine");
        Stack<String> stack = new Stack<>();

        for (String s : input) {
            stack.push(s);
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
            if (stack.isEmpty()) break;
            stack.pop();
        }
        int length = input.size();

        System.out.println("Using streams");

        IntStream.range(0, length)
                .map(n -> length - n - 1)
                .filter(n -> n%2 != length % 2)
                .mapToObj(input::get)
                .forEach(System.out::println);

    }
}
