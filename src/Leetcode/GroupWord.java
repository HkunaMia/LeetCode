package Leetcode;

import java.util.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/8/3
 * \* Time: 10:16
 * \* To change this template use File | Settings | File Templates.
 * \* Description:给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * \
 */

public class GroupWord {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0 || strs == null){
            return new ArrayList<>();
        }
        Map<String,List> res = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
//            通过排序让不字母顺序的字符串拥有相同的键
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if(!res.containsKey(s)) res.put(s,new ArrayList());
            res.get(s).add(str);
        }
        return new ArrayList(res.values());
    }
}
