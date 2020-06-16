package Thread;

import java.util.concurrent.Callable;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/25 16:27
 * @description：
 * @modified By：
 */

public class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            //返回执行当前 Callable 的线程名字
            return Thread.currentThread().getName();
        }

}
