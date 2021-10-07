package primarySort;

/**
 * <pre>
 * 	�������������裬����û���ظ���Ԫ��
 * 	�ռ䣺ΪO(1)
 * 	ʱ�䣺N*logN
 *
 * 	����1�������󶥶�(��С����)
 * 	����2���� �Ѷ� Ԫ�� �� δ���� ������һ��Ҷ�ӣ����н���
 * 	����3�����԰��ѽ�������(��������������Ҷ��)
 * 	����4���ظ�����2,3
 * </pre>
 */
public class HeapSort {
    /**
     * <pre>
     * �����󶥶ѣ�����û���ظ���Ԫ��
     * 1���±�Ϊ0��Ԫ�أ���ʾԪ�����������±�1��ʼ��ʾԪ��ֵ����������ԭ��������Ϊ�˸������ļ��㣬���¿�
     * 2�������������е�ֵ�����±�1��ʼ������ĩβ����ʾһ����ȫ��������˳���洢
     * 3����ô���Եó�����λ�ù�ϵ��
     * 		(1)��i��Ԫ�صĸ�����i/2
     * 		(2)��i��Ԫ�ص���������L=2*i���Һ�����R=2*i+1����L+1
     * 4����������һ��Ԫ�ص��±���i����˫���±�Ϊj=i/2���������ζ�[1,j]��Ԫ�ؽ��жѹ�������
     * </pre>
     */
    public void initHeap(int[] s) {
        // ����һ��Ҷ�ӵ�˫���±�
        int lastParentIndex = s[0] / 2;

        // �԰��ѽ�������
        for (int i = lastParentIndex; i > 0; i--) {
            this.reBuild(i, s, s[0]);
        }
    }

    /**
     * <pre>
     * �԰��ѽ������������ѵ���˼�ǣ����Ѷ�Ԫ���⣬����Ԫ�ض����϶Ѷ���
     * </pre>
     *
     * @param i ����Ԫ�����ɵĶѵĶѶ�
     * @param s Ԫ������
     * @param last δ������Ԫ���±�
     */
    private void reBuild(int i, int[] s, int last) {
        System.out.printf("\n-------------------- rebuild --------------------");
        System.out.printf("\ni=%d��s[i]=%d, last=%d", i, s[i], last);
        // �±�Ϊi���������±�
        int L = 2 * i;
        // �±�Ϊi���Һ����±�
        int R = L + 1;
        // ���Һ����н�С��һ��
        int minLR = -1;

        // �±�Ϊi��Ԫ��û�к���
        if (L > last && R > last) {
            System.out.printf("\nno children");
            return;
        }

        // �±�Ϊi��Ԫ��ֻ��������
        if (L <= last && R > last) {
            minLR = L;
        }

        // �±�Ϊi��Ԫ��ֻ���Һ���
        if (L > last && R <= last) {
            minLR = R;
        }

        // �±�Ϊi��Ԫ������������
        if (L <= last && R <= last) {
            minLR = s[L] < s[R] ? R : L;
        }

        System.out.printf("\nminLr=%d, s[minLR]=%d", minLR, s[minLR]);

        // �Ƚ���������Ԫ�أ�˫�ף�˫�׵������ӣ�˫�׵��Һ���
        if (s[i] > s[minLR]) {
            System.out.printf("\n i=%d, s[i]=%d is the max one.", i, s[i]);
            return;
        } else {
            this.swap(i, minLR, s);
            // �ݹ����жѵ���
            this.reBuild(minLR, s, last);
        }
    }

    // Ԫ�ؽ���
    private void swap(int i, int j, int[] s) {
        System.out.printf("\nswap, i=%d, s[i]=%d, j=%d, s[j]=%d", i, s[i], j, s[j]);
        int t = s[i];
        s[i] = s[j];
        s[j] = t;
    }

    /**
     * <pre>
     * ������
     * 1���� �Ѷ� Ԫ�� �� δ���� ������һ��Ҷ�ӽ���(������������Ҷ�����������ģ������Ķѵ��������ٿ�������Ҷ��Ԫ����)
     * 2�����Ѷ�Ԫ�ذ��նѶ��壬���ν����³���ֱ���¶ѷ��϶Ѷ���
     * 3���ظ�1,2
     * </pre>
     *
     * @param s
     */
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