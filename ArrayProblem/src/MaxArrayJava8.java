import java.util.Arrays;

public class MaxArrayJava8 {
    public static void main(String[] args) {
        int num[]={2,8,1,9,250};
        int max= Arrays.stream(num).max().orElseThrow();
        System.out.println(max);
    }
}
