package extra;

public class trapRainWater01 {
    public static int trapRainWater(int[] heights) {
        // write your code here
        int left = 0, right = heights.length - 1;
        int res = 0;
        if(left >= right)
            return res;
        int leftheight = heights[left];
        int rightheight = heights[right];
        while(left < right) {
            if(leftheight < rightheight) {
                left ++;
                if(leftheight > heights[left]) {
                    res += (leftheight - heights[left]);
                } else {
                    leftheight = heights[left];
                }
            } else {
                right --;
                if(rightheight > heights[right]) {
                    res += (rightheight - heights[right]);
                } else {
                    rightheight = heights[right];
                }
            }
        }
        return res;

    }
    public static void main(String[] args) {
        int[]arr= {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapRainWater(arr));
    }

}