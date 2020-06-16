package huawei;

import java.util.*;

//c输出所有字符串的排列,offer38题

public class StringPermutation {

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s){
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int index){
        if(index == c.length-1){
            res.add(String.valueOf(c));
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for(int i = index;i<c.length;i++){
            if(set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i,index);
            dfs(index+1);
            swap(index,i);
        }
    }

    void swap(int a,int b){
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    public static void main(String[] args) {
        StringPermutation stringPermutation = new StringPermutation();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        stringPermutation.permutation(s);
        System.out.println(stringPermutation.res);
    }
}
