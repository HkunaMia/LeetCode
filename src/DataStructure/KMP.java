package DataStructure;

import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/17 21:14
 * @description：字符串匹配算法
 * @modified By：
 */

public class KMP {

    public int[] getNext(String pattern){
        int j = 0;
        int i = 1;
        int[] next = new int[pattern.length()];
        while (i<pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(j)){
                next[i] = j+1;
                i++;
                j++;
            }else if (j==0){
                next[i]=0;
                i++;
            }else j = next[j-1];
        }
        return next;
    }

    public int kmpSearch(String s,String pattern){
        int[] next = getNext(pattern);
        int n = s.length();
        int m = pattern.length();
        int i = 0,j=0;
        while(i<n && j<m){
            if(s.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else if(j != 0) j = next[j-1];
            else i++;
        }
        if(j==m) return i-j;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().trim();
        String pattern = in.nextLine();
        KMP kmp = new KMP();
        int[] next = kmp.getNext(pattern);
//        System.out.println(Arrays.toString(next));
        int res = kmp.kmpSearch(s,pattern);
        System.out.println(res);
    }
}
