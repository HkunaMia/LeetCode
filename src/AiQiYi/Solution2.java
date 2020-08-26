package AiQiYi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/23 15:49
 * @description：
 * @modified By：
 */

public class Solution2 {

    public static boolean isPath(String path){
//        int i = 0,j=0;
//        Set<Integer> po = new HashSet<>();
//        po.add(0);
//        char[] chars = path.toCharArray();
//        for (char aChar : chars) {
//            switch (aChar){
//                case 'N':j++;break;
//                case 'S':j--;break;
//                case 'E':i++;break;
//                case 'w':i--;break;
//            }
//            int pos = 10001*i+j;
//            if (po.contains(pos)) {
//
//                return true;
//            }
//            po.add(pos);
//        }
//        return false;
        if (path == null || "".equals(path)) {
            return false;
        }

        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();

        set.add("0,0");

        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;

                default:
                    break;
            }
            if(!set.add(x + "," + y)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if(isPath(s)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

    }
}
