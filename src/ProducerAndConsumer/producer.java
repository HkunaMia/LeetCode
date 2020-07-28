package ProducerAndConsumer;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/7/22
 * \* Time: 15:14
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class producer implements Runnable {

//    volatile保证该表职位的可见性
    private volatile boolean isRunning = true;
//    内存缓冲区，final保证内存缓冲区的唯一
    private final Vector sharedQueue;
//    缓冲区大小，需要手动判断队列是否满
    private final int SIZE;
//    总数，原子操作
//    static关键词保证该类在内存中只存在一份

    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEPTIME = 1000;

    public producer(Vector sharedQueue,int SIZE){
        this.sharedQueue = sharedQueue;
        this.SIZE = SIZE;
    }

    @Override
    public void run() {
        int data;
        Random r = new Random();

        System.out.println("start producer id = " + Thread.currentThread().getId());
        try{
            while(isRunning){
//                模拟网络延迟，在该范围内选择任意的睡眠时间
                Thread.sleep(r.nextInt(SLEEPTIME));

//                当队列满阻塞等待
                while(sharedQueue.size() == SIZE){
                    synchronized(sharedQueue){
                        System.out.println("queue id full,producer "+ Thread.currentThread().getId() +
                                " is waiting,size :" + sharedQueue.size());
                        sharedQueue.wait();
                    }
                }

//                当队列不满时，持续创造新元素
                synchronized (sharedQueue){
//                    构造任务数据
//                    原子类的操作都是原子性的，incrementAndGet方法是线程安全的
                    data = count.incrementAndGet();
                    sharedQueue.add(data);
                    System.out.println("producer create data :" + data + ", size :" + sharedQueue.size());
                    sharedQueue.notifyAll();
                }
            }

        }catch (InterruptedException e){
            e.printStackTrace();
//            终止进程
            Thread.currentThread().interrupt();
        }
    }


    public void stop(){
        isRunning = false;
    }
}
