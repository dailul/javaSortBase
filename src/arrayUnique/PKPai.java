package arrayUnique;

import java.util.Arrays;

public class PKPai {
    /*
     * ��Ĭ�ϳ�ʼ�ƶ�Ϊ1-n,������������
     */
    public static int[] pkPai(int n) {
        // ����һ�����飬���Ƹ�ֵ
        int[] m = new int[n];
        for (int i = 0; i < m.length; i++) {
            m[i] = i + 1;
        }
        int[] j = new int[n];// �������Ƶ�����
        int count = 0;
        while (count < n) {
            // һֱ���ƣ���һ�ŷ������ϣ��ڶ��ŷ��Ƶͣ�ѭ������
            for (int i = 0; i < m.length; i++) {
                if (i % 2 == 0) {
                    j[count] = m[i];
                    count++;
                }
                // ��������:ÿ���Ƶͼ�һ�ű�������������+1
                if (i % 2 == 1) {
                    int l = m[i];
                    m = Arrays.copyOf(m, m.length + 1);
                    m[m.length - 1] = l;
                }
            }
            // ��ת����
            // Collections.reverse(list);
        }
        return j;
    }
    public static int[] pai(int[] j) {
        int length = j.length;
        // ��������������������
        int[] r = new int[length];
        int count = 0;
        // �û�����
        for (int i = length; i > 0; i--) {
            r[j[count] - 1] = i;
            count++;
        }
        return r;
    }
    public static void main(String[] args) {
        int[] p = pkPai(5);
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println();
        int[] pai = pai(p);
        for (int i = 0; i < pai.length; i++) {
            System.out.print(pai[i] + " ");
        }
    }
}