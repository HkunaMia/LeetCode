package Leetcode;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/12 11:34
 * @description：正则表达式匹配
 * @modified By：
 */

public class offer19 {

    public boolean isMatch(String A, String B){
        if(A.length()==0){
//            剩余B必须是偶数个，且为a*b*格式才能匹配成功
            if(B.length()%2 != 0){
                return false;
            }
//            且*必须在奇数位上
            int i = 1;
            while (i < B.length()) {
                if (B.charAt(i) != '*') return false;
                i += 2;
            }
            return true;

        }
//        当正则串为空，主串不为空时，匹配失败
        else if(A.length() > 0 && B.length()==0){
            return false;
        }

        if (B.length()>1 && B.charAt(1)=='*'){
            if(A.charAt(0)==B.charAt(0) || B.charAt(0) == '.'){
                return isMatch(A.substring(1),B) || isMatch(A,B.substring(2));
            }else{
                return isMatch(A,B.substring(2));
            }
        }
        else if (A.charAt(0)==B.charAt(0) || B.charAt(0) == '.'){
            return isMatch(A.substring(1),B.substring(1));
        }else {
            return false;
        }


    }
}
