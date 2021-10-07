package primarySort;

public class InsertSort {
    public static int[] InsertSort(int[]arr) {
        for(int i=1;i<arr.length;i++) {
            int temp=arr[i];
            int j;
            for(j=i-1;j>=0&&temp<arr[j];j--) {
                arr[j+1]=arr[j];
            }
            arr[j+1]=temp;
        }



        return arr;
    }
    public static void main(String[] args) {
        int []arr= {1,6,9,78,23,58,20};
        arr=InsertSort(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}