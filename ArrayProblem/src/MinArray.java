public class MinArray {
    public static void main(String[] args) {
        int a[]= {1,9,5,4,25};
        int min=a[0];
        for(int i=0;i<a.length;i++){
            if (a[i]<min){
                min=a[i];
            }
        }
        System.out.println(min);
    }
}
