package primarySort;

public class HeapSort {

    public void initHeap(int[] s) {

        int lastParentIndex = s[0] / 2;


        for (int i = lastParentIndex; i > 0; i--) {
            this.reBuild(i, s, s[0]);
        }
    }

    private void reBuild(int i, int[] s, int last) {
        System.out.printf("\n-------------------- rebuild --------------------");
        System.out.printf("\ni=%d��s[i]=%d, last=%d", i, s[i], last);

        int L = 2 * i;

        int R = L + 1;

        int minLR = -1;


        if (L > last && R > last) {
            System.out.printf("\nno children");
            return;
        }


        if (L <= last && R > last) {
            minLR = L;
        }


        if (L > last && R <= last) {
            minLR = R;
        }


        if (L <= last && R <= last) {
            minLR = s[L] < s[R] ? R : L;
        }

        System.out.printf("\nminLr=%d, s[minLR]=%d", minLR, s[minLR]);


        if (s[i] > s[minLR]) {
            System.out.printf("\n i=%d, s[i]=%d is the max one.", i, s[i]);
            return;
        } else {
            this.swap(i, minLR, s);

            this.reBuild(minLR, s, last);
        }
    }


    private void swap(int i, int j, int[] s) {
        System.out.printf("\nswap, i=%d, s[i]=%d, j=%d, s[j]=%d", i, s[i], j, s[j]);
        int t = s[i];
        s[i] = s[j];
        s[j] = t;
    }

    public void heapSort(int[] s) {
        System.out.printf("\n---------------------- heapSort ----------------------");
        for (int j = s[0]; j > 0; j--) {
            System.out.printf("\n�ҵ���Сֵ:%d", s[1]);
            this.swap(1, j, s);
            PrintArray(s);
            this.reBuild(1, s, j - 1);
            PrintArray(s);
        }
    }

    // ��ӡ����
    private static void PrintArray(int[] s) {
        System.out.printf("\n-----------------------------------");
        System.out.printf("\n�±�:");
        for (int p = 0; p < s.length; p++) {
            System.out.printf("%2d,", p);
        }
        System.out.print("\nֵֵ:");
        for (Integer m : s) {
            System.out.printf("%2d,", m);
        }
    }

    public static void main(String[] args) {
        // int[] s = new int[] { 99, 88, 5, 99, 7, 9, 3, 8, 10, 90, 56, 83, 39, 22 };
        int[] s = new int[] { 7, 5, 2, 8, 3, 1, 6, 9 };
        PrintArray(s);

        HeapSort heapSort = new HeapSort();
        heapSort.initHeap(s);
        PrintArray(s);
        heapSort.heapSort(s);

        PrintArray(s);
    }

}