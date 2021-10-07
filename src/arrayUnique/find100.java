package arrayUnique;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class find100 {
    public static Set<Integer>getTop100(int[]inputArray){
        TreeSet<Integer>top100=new TreeSet<Integer>();
        for(int i=0;i<inputArray.length;i++) {
            if(top100.size()<100) {
                top100.add(inputArray[i]);
            }else if((Integer)top100.first()<inputArray[i]) {
                Object obj=top100.first();
                top100.remove(obj);
                top100.add(inputArray[i]);
            }
        }
        return top100;
    }
    public static void main(String[] args) {
        int numberCount=10000000;
        int maxNumber=numberCount;
        int inputArray[]=new int[numberCount];
        Random random=new Random();
        for(int i=0;i<numberCount;i++) {
            inputArray[i]=Math.abs(random.nextInt(maxNumber));
        }
        System.out.println("Sort begin.....");
        long current=System.currentTimeMillis();
        Set<Integer>result=getTop100(inputArray);
        System.out.println(System.currentTimeMillis()-current);

    }
}
