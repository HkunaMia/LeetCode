package ProducerAndConsumer;

import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/7/22
 * \* Time: 15:58
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class ProducerWithBQ implements Runnable{

    private volatile boolean isRunning = true;
//    内存缓冲区
    private BlockingQueue<Integer> queue;
    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEPTIME = 1000;

    public ProducerWithBQ(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }


    public void run(){
        int data ;
        Random r = new Random();

        System.out.println("start producer id = " + Thread.currentThread().getId());

        try{
            while(isRunning){
                Thread.sleep(r.nextInt(SLEEPTIME));

                data = count.incrementAndGet();
                System.out.println("producer "+ Thread.currentThread().getId() + "produce data :" +data
                        + ",size: " + queue.size());
                if(!queue.offer(data,2, TimeUnit.SECONDS)){
//              将指定元素插入此队列中（如果立即可行且不会违反容量限制），成功时返回 true，如果当前没有可用的空间，则返回 false，不会抛异常
                    System.out.println("FAILED to put data:" + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop(){
        isRunning = false;
    }
}
