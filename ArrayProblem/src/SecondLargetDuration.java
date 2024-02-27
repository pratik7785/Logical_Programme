public class SecondLargetDuration {
    //it takes so much time
    public static void main(String[] args) {
        int a[]= {1,9,5,4,25};
        int temp;
        for (int i=0;i<a.length;i++){
            for (int j=i+1;j<a.length;j++){
                if (a[i]<a[j]){
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }

            }
            if (i==1){
                break;
            }
        }

        System.out.println("Second larget element= "+a[1]);
    }
}
