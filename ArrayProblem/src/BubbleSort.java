public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {1, 9, 5, 4, 25};
        int target=16;
        int result=binarySerch(a,target);
        for (int b:a)
        System.out.print(b+" ");
        if (result!=-1){
            System.out.println("\nat index"+result);
        }
        else {
            System.out.println("\nnot found");
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }


            }

        }


        }
    static int binarySerch(int[] arr, int target){
        int left=0;
        int right= arr.length-1;
        while(left<=right) {
            int mid = left + (right - left) /2;
            if (arr[mid] ==target){
                return mid;
            }
            if (arr[mid]<target){
                left=mid+1;


        }
            else {
                right=mid-1;
            }

        }
        return -1;

    }
}