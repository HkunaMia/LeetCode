package QiHu360;


import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/24 11:13
 * @description：
 * @modified By：
 */

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        for(int i = 0;i<line.length();i++){
            if(i==0){
                line = line.substring(0,1).toUpperCase()+line.substring(1);
            }else{
                if(line.charAt(i) =='n'){
                    line = line.substring(0,i) +"\n"+'N'+line.substring(i+1);
                }
            }
        }
        System.out.println(line);
    }
}
