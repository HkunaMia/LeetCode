package bilibili;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/13 19:41
 * @description：
 * @modified By：
 */

public class three {
    public int GetCoinCount (int N) {
        // write code here
        int num = 1024 - N;
        if(num == 0) return 0;
        else{
            int num64 = num/64;
            num -= num64 * 64;
            int num16 = num/16;
            num -= num16 * 16;
            int nunm4 = num/4;
            num -= nunm4*4;
            return num + nunm4 + num16 +num64;
        }
    }

    public boolean Game24Points (int[] arr) {
        // write code here
        List<Double> list = new ArrayList<>();
        for(int i=0;i<4;i++){
            list.add((double)arr[i]);
        }
        boolean flag = false;
        for(int j=0;j<4;j++){
            Double cur = list.remove(j);
            if(helper(list,cur)){
                flag = true;
                break;
            }
            list.add(j,cur);
        }
        return flag;
    }

    public boolean helper(List<Double> list ,double cur){
        if(list.size() == 0 && Math.abs(cur - 24) < 0.00001) {
            return true;
        }else if(list.size() == 2){
            double[] temp = new double[3];
            temp[0] = list.get(0) + list.get(1) ;
            temp[1] = list.get(0) - list.get(1);
            temp[2] = list.get(1) - list.get(0);
            double temp1 = list.get(0);
            double temp2 = list.get(1);
            list = new ArrayList<Double>();
            for(int i =0;i<3;i++){
                list.add(0,temp[i]);
                if(helper(list,cur)){
                    return true;
                }
                list.remove(0);
            }
            list.add(temp1);
            list.add(temp2);
        }
        for(int i = 0;i<list.size();i++){
            double temp = list.get(i);
            list.remove(i);
            if(helper(list,cur + temp)
                    || helper(list,cur-temp)
                    || helper(list,temp-cur)
                    || helper(list,cur*temp)
                    || helper(list,cur/temp)
                    || helper(list,temp/cur)){
                return true;
            }
            list.add(i,temp);
        }
        return false;
    }

}
