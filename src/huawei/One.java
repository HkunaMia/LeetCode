package huawei;

import java.util.*;

public class One {
    public static LinkedList<Integer> list = new LinkedList<Integer>();

    public static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().strip().split(" ");
        int[] num = new int[s.length];
        for(int i = 0;i<s.length;i++){
            if(set.contains(s[i])) continue;
            set.add(s[i]);
        }
        for (String s1 : set) {
            int temp = 0;
            while(temp<3){
                list.add(Integer.parseInt(s1));
                temp++;
            }
        }

//        System.out.println(list.size());
        for(int i =0;i<list.size()-1;i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.print(list.get(list.size()-1));
    }
}
