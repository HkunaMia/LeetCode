package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/8/19
 * \* Time: 19:21
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class Soluton1 {

    public static ArrayList<int[]> CriclePrint(int m, int n){
        int top = 0;
        int down = m-1;
        int left = 0;
        int right = n-1;
        int count = 0;
        ArrayList<int[]> res = new ArrayList<>();
        while(top<=down && left<=right){
            for(int i = left;i<=right;i++){
                count++;
                if(isRight(count)){
                    res.add(new int[]{top,i});
                }
            }
            top++;
            for(int j = top;j<=down;j++){
                count++;
                if(isRight(count)){
                    res.add(new int[]{j,right});
                }
            }
            right--;
            for(int k = right;k>=left;k--){
                count++;
                if(isRight(count)){
                    res.add(new int[]{down,k});
                }
            }
            down--;
            for(int l = down;l>=top;l--){
                count++;
                if(isRight(count)){
                    res.add(new int[]{l,left});
                }
            }
            left++;
        }
        return res;
    }

    public static boolean isRight(int count){
        int g = count%10;
        int s = count%100/10;
        if(g==7 && s%2==1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        ArrayList<int[]> ints = Soluton1.CriclePrint(m, n);
        System.out.print("[");
        for (int i = 0;i<ints.size();i++){
            if(i<ints.size()-1){
                System.out.print(Arrays.toString(ints.get(i)) + ",") ;
            }else{
                System.out.println(Arrays.toString(ints.get(i))+"]");
            }
        }
    }
}
