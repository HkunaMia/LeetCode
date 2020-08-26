package qiAnXin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/8/1
 * \* Time: 16:14
 * \* To change this template use File | Settings | File Templates.
 * \* Description:给出一组个位数（有重复），求他们的全排列，输出能被7整除的
 * \
 */

public class Two2 {

    List<List<Integer>> list;
    private  int[] digit;

    public int permuteUnique(int[] digit){
        this.digit = digit;
        list = new LinkedList<>();
        Arrays.sort(digit);
        List<Integer> ll = new LinkedList<Integer>();
        boolean[] flag = new boolean[digit.length];
        dfs(ll,flag,0);
        return list.size();
    }

    public void dfs(List<Integer> ll,boolean[] flag,int length){
        if(length== digit.length){
            int sum = 0;
            for(int i:ll){
                sum = sum*10+i;
            }
            if(sum %7 == 0)
                list.add(new LinkedList<>(ll));
            return;
        }
        for(int i=0;i<digit.length;i++){
            if(flag[i])continue;
            ll.add(digit[i]);
            flag[i] = true;
            dfs(ll,flag,length+1);
            ll.remove(ll.size()-1);
            flag[i] =false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strings = str.split(" ");
        int[] nums = new int[strings.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.valueOf(strings[i]);
        }

        Two2 m = new Two2();
        System.out.println(m.permuteUnique(nums));

    }
}
