public class DuplicateBruteForce {
    public static void main(String[] args) {
        int a[]= {3,9,3,4,9};
        System.out.println("Duplicate");
        for (int i=0;i<a.length;i++){
            for (int j=i+1;j<a.length;j++){
                if(a[i]==a[j]&&(i!=j)){
                    System.out.print(a[i]+" ");
                }
            }
        }
    }
}
