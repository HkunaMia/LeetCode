package tenxun;

import java.util.*;
public class tenxunOne {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int times = Integer.parseInt(in.nextLine());

            ArrayList<String[]> list = new ArrayList<>();
            while (times > 0){
                int q = Integer.parseInt(in.nextLine());
                String[] doIt = new String[q];
                for (int i = 0; i < q; i++) {
                    doIt[i] = in.nextLine();
                }
                list.add(doIt);
                times--;
            }
            in.close();

            for (String[] strings : list) {
                Queue<Integer> queue = new LinkedList<>();
                for (String operator : strings) {
                    if (operator.startsWith("PUSH")){
                        String[] inputs = operator.split(" ");
                        queue.offer(Integer.parseInt(inputs[1]));
                    }
                    if (operator.equals("POP")){
                        if (queue.isEmpty()){
                            System.out.println(-1);
                        }else {
                            queue.poll();
                        }
                    }
                    if (operator.equals("TOP")){
                        if (queue.isEmpty()){
                            System.out.println(-1);
                        }else {
                            System.out.println(queue.peek());
                        }
                    }
                    if (operator.equals("SIZE")){
                        System.out.println(queue.size());
                    }
                    if (operator.equals("CLEAR")){
                        queue.clear();
                    }
                }
            }

        }
}
