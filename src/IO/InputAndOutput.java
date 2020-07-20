package IO;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/7/14
 * \* Time: 11:34
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class InputAndOutput {

//    字符串输入转int数组,形如[1,2,3,4,5,6]
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
//        这里切割的时候，省去了两头的方括号
//        input = input.substring(1, input.length() - 1);

        if (input.length() == 0) {
            return new int[0];
        }

//        以逗号分隔
        String[] parts = input.split(",");
//        以空格分隔
//        String[] parts = input.split(" ");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

//    int数组转string输出
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        for(int index = 0; index < length; index++) {
            int number = nums[index];
//            连接并加逗号
            result.append(Integer.toString(number)).append(", ");
        }

//        切掉最后一个数添加的“， ”，再加括号
        return result.substring(0, result.length() - 2);
    }

    public static String integerArrayToString(int[] nums) {

        return integerArrayToString(nums, nums.length);
    }
}
