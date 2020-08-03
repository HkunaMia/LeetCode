import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static String toBinary(String s){
        Integer integer = Integer.valueOf(s);

        if(integer==0){
            return "";
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (integer !=0){
            int i = integer%10;
            ans.add(i);
            integer = integer/10;
        }
        Collections.reverse(ans);
        String res = "";
        for (int i =0;i<ans.size();i++) {
            String s1 = Integer.toBinaryString(Integer.valueOf(ans.get(i)));
            while(s1.length()<4){
                s1 = '0' + s1;
            }
            res+=s1;
        }
        while (res.length()<12){
            res = '0'+res;
        }

        String reverse = new StringBuffer(res).reverse().toString();

        while (reverse.charAt(0)=='0'){
            reverse = reverse.substring(1, reverse.length());

        }
        return reverse;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] strings = in.nextLine().split(" ");
        for(int i = 0;i<n;i++){
            String s = Main.toBinary(strings[i]);
            System.out.println(s);
        }
    }
}
