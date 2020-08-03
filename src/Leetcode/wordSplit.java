package Leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/7/30
 * \* Time: 11:29
 * \* To change this template use File | Settings | File Templates.
 * \* Description:top100中单词是否能被分割成字典中出现的单词
 * \
 */

public class wordSplit {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> dict = new HashMap<>(wordDict.size());
        for (String s1 : wordDict) {
            if(!dict.containsKey(s1)){
                dict.put(s1,true);
            }
        }
        boolean[] dp =  new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 0;i<s.length();i++){
            for(int j =i+1;j<s.length()+1;j++){
                if(dp[i]==true && dict.containsKey(s.substring(i,j))){
                    dp[j] = true;
                }
            }
        }
        return dp[dp.length-1];
    }
}
