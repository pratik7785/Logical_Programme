public class MaxArray {
    public static void main(String[] args) {
        int a[]= {1,9,5,4,25};
        int max=a[0];
        for (int i=1;i< a.length;i++){
            if (a[i]>max){
                max=a[i];

            }
        }
        System.out.println(max);
    }
}
