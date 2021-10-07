package primarySort;

import java.util.Arrays;

public class heap {
    public void heapSort(int[] num){
        int n = num.length;
        for(int i = n/2;i>=0;i--){   //���ѣ���n/2��ʼ���ϵ���
            adjustHeap(num, i, n);
        }
        for(int j=n-1;j>=0;j--){
            swap(num,0, j);         //������ʼ������λ���ϵ�����
            adjustHeap(num, 0, j);    //����֮���ٵ�����
        }
    }
    public void adjustHeap(int[] num,int s,int n){  //���ڸ��ڵ������Ǵ�0��ʼ�ģ���������������2*i+1
        for(int i=s;i<n;){
            int max = i;
            if((2*i+1)<n&&num[2*i+1]>num[max]) max = 2*i+1;
            if((2*i+2)<n&&num[2*i+2]>num[max]) max = 2*i+2;
            if(max!=i){
                swap(num,i,max);
                i=max;
            }else break;

        }

    }
    public void swap(int[] num,int i,int j){
        int tem = num[i];
        num[i] = num[j];
        num[j] = tem;
    }
    public static void main(String[] args) {
        heap heap = new heap();
        int[] num = new int[]{49,38,65,97,76,13,27,49};
        heap.heapSort(num);
        System.out.println(Arrays.toString(num));
    }
}