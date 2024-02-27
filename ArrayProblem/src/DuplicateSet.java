import java.util.HashSet;
import java.util.Set;

public class DuplicateSet {
    public static void main(String[] args) {
        int a[]= {1,9,5,4,1,9};
        Set<Integer> s=new HashSet<>();
        for (int n:a){
            if(s.add(n)==false){
                System.out.print(n+" ");
            }
        }
    }
}
