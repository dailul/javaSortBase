package extra;

public class trapRainWater02 {
    public static int trap(int[] height) {
        if(height == null || height.length <= 2)
            return 0;
        int maxL = height[0];
        int[] maxRs = new int[height.length];
        int waterSum = 0;//�����ܵ�ˮ��
        int maxR = 0;
        for(int i = height.length - 1; i >= 0; i--){
            if(height[i] > maxR) {
                maxRs[i] = maxR = height[i];
            }
            else {
                maxRs[i] = maxR;
            }
        }
        for(int i = 1; i < height.length - 1; i++){
            if(height[i] > maxL) {
                maxL = height[i];//������������ֵ
            }
            waterSum += Math.max(Math.min(maxL, maxRs[i]) - height[i], 0);
        }
        return waterSum;

    }

    public static void main(String[] args) {
        int[]arr= {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }

}