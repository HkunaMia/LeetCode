package jindong;

import java.util.Scanner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/8/6
 * \* Time: 19:45
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class HuiWen2 {


    public static boolean isPrimeNum(int a){		//判断是否是素数
        for(int i=2 ; i<=Math.sqrt(a) ; i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
    public static int fanxuNum(int a){			//求反序数
        int length1 = (a+"").length();
        if(length1==1){
            return a;
        }
        if(length1==2){
            int x = a/10;
            int y = a%10;
            return y*10+x;
        }
        else{
            int x = a/100;
            int y = a/10%10;
            int z = a%10;
            return x+y*10+z*100;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int count = 0;
        Boolean flag = false;
        for(int i = n;i<=m;i++){
            flag = false;
            String s = Integer.toString(i);
            for(int j = 0;j<s.length();j++){
                String newString = s.substring(0,j) + s.substring(j+1,s.length());
                int anInt = Integer.parseInt(newString);
                if(isPrimeNum(anInt)&&fanxuNum(anInt)==anInt){
                    flag = true;
                }
            }
            if(flag){
                count++;
            }

        }
        System.out.println(count);
    }

}
