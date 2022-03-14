package primarySort;

public class mergeSort {

    public static void merge(int[]arr,int[]arr1,int s,int m,int t) {
        int i=s;
        int j=m+1;
        int k=s;
        while(i<=m&&j<=t) {
            if(arr[i]<arr[j]) {
                arr1[k++]=arr[i++];
            }else {
                arr1[j++]=arr[j++];
            }
        }
        while(i<=m) {
            arr1[k++]=arr[i++];
        }
        while(j<=t) {
            arr1[k++]=arr[j++];
        }
    }
    public static void mergePass(int[]arr,int[]arr1,int h,int n) {
        int i=0;
        while((i+2*h-1)<=n) {
            merge(arr,arr1,i,i+h-1,i+2*h-1);
            i+=2*h;
        }
        if(i+h-1<n) {
            merge(arr,arr1,i,i+h-1,n);
            i+=2*h;
        }else {
            for(;i<=n;i++) {
                arr1[i]=arr[i];
            }
        }

    }

    public static void mergeSort(int []arr,int[]arr1) {
        int h=1;
        int n=arr.length;
        while(h<n) {
            mergePass(arr,arr1,h,n);
            h=2*h;
            mergePass(arr1,arr,h,n);
            h=2*h;

        }
    }
    public static void main(String[] args) {
        int []arr1= {};
        int []arr= {1,6,9,78,23,58,20};
        mergeSort(arr,arr1);
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

}