public class SecondLarget {
    //it is efficient method
    public static void main(String[] args) {
        int a[]= {1,9,5,4,25};
        int largest=Integer.MIN_VALUE;
        int secondLargest= Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if (a[i]>largest){
                secondLargest=largest;
                largest=a[i];
            } else if (a[i]>secondLargest && a[i]!=largest) {
                secondLargest=a[i];
                
            }
        }
        System.out.println(secondLargest);
    }
}
