package huawei;

import java.util.*;

public class One2 {
    public static LinkedList<Integer> list = new LinkedList<Integer>();

//    public static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().strip().split(" ");
        int[] num = new int[s.length];
        for (int i =0;i<3;i++){
            list.add(Integer.parseInt(s[0]));
        }
        for (int i=1;i<s.length;i++){
            if(s[i].equals(s[i-1])) continue;
            int temp = 0;
            while (temp<3){
                list.add(Integer.parseInt(s[i]));
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
