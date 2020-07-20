package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/7/14
 * \* Time: 11:38
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = InputAndOutput.stringToIntegerArray(line);
//            line = in.readLine();
//            int k = Integer.parseInt(line);

//            int[] ret = new Solution().topKFrequent(nums, k);

            String out = InputAndOutput.integerArrayToString(nums);

            System.out.print(out);
        }
    }
}
