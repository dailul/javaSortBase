package primarySort;

public class quickSort {
    public static void quickSort(int[] a,int low,int high){
        int start = low;
        int end = high;
        int key = a[low];

        while(end>start){

            while(end>start&&a[end]>=key)
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }

            while(end>start&&a[start]<=key)
                start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }

        }

        if(start>low) quickSort(a,low,start-1);
        if(end<high) quickSort(a,end+1,high);
    }

    public static void main(String[] args) {
        int []arr= {1,6,9,78,23,58,20};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}