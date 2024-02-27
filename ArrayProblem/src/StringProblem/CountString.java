package StringProblem;

import java.util.Arrays;
import java.util.List;

public class CountString {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "apple", "grape", "banana", "apple");
        Long s=fruits.stream().filter(n->n.equals("apple")).count();
        System.out.println(s);

    }
}
