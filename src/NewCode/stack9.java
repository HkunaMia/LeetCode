package NewCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/28 11:46
 * @description：求最大子矩阵大小
 * @modified By：
 */

public class stack9 {

    public int maxRecSize(int[][] map){
        if(map==null || map.length == 0 || map[0].length ==0 ){
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea,maxAreaFromBottom(height));
        }
        return maxArea;
    }

    public int maxAreaFromBottom(int[] height){
        Stack<Integer> stack = new Stack<>();
        int[] newHeight = new int[height.length+2];
        newHeight[0] = 0;
        System.arraycopy(height,0,newHeight,1,height.length);
        newHeight[newHeight.length-1] = 0;
        stack.push(newHeight[0]);
        int res = 0;
        for(int i =1;i<newHeight.length;i++){
            while (!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]){
                int current_height = newHeight[stack.pop()];
                int left = stack.peek();
                int width = i - left-1;
                res = Math.max(res,current_height*width);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int[][] map = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                map[i][j] = in.nextInt();
            }
        }
//        for(int i=0;i<rows;i++){
//            for(int j=0;j<cols;j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.print("\n");
//        }
        stack9 stack9 = new stack9();
        int res = stack9.maxRecSize(map);
        System.out.println(res);
    }
}
