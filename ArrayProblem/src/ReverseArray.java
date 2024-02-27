public class ReverseArray {
    public static void main(String[] args) {
        int a[]= {1,9,5,4,25};
        reverseArray(a);
        printArray(a);


    }
    static void reverseArray(int [] arr){
        int start=0;
        int end=arr.length-1;
        while (start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    static void printArray(int [] arr){
        for (int num:arr){
            System.out.println(num+" ");
        }
    }

}
