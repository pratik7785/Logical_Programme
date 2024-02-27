import java.util.Arrays;

public class MinArrayJava8 {
    public static void main(String[] args) {
        int a[]= {1,9,5,4,25};
        int min= Arrays.stream(a).min().orElseThrow(()->new RuntimeException("Runtime Exception"));
        System.out.println(min);


    }
}
