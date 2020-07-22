package ProducerAndConsumer;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/7/22
 * \* Time: 15:36
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class consumer implements Runnable {

    private final Vector sharedQueue;
    private final int SIZE;
    private final int SLEEPTIME = 1000;

    public consumer(Vector sharedQueue,int SIZE){
        this.sharedQueue = sharedQueue;
        this.SIZE = SIZE;
    }

    @Override
    public void run(){
        Random r = new Random();

        System.out.println("start consumer id = " + Thread.currentThread().getId());

        try{

            while (true){

//                模拟延迟
                Thread.sleep(r.nextInt(SLEEPTIME));

//                当队列空就阻塞
                while (sharedQueue.isEmpty()){
                    synchronized (sharedQueue){
                        System.out.println("queue is empty,consumer " + Thread.currentThread().getId()
                                + " is waiting ,size： " + sharedQueue.size());
                        sharedQueue.wait();
                    }
                }

//                队列不空，持续消费
                synchronized (sharedQueue){
                    System.out.println("consumer consume data: " + sharedQueue.remove(0) + ",size:" + sharedQueue.size());
                    sharedQueue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Vector sharedQueue = new Vector();
        int size = 4;

//        建立线程池和线程
        ExecutorService service = Executors.newCachedThreadPool();
        producer producer1 = new producer(sharedQueue,4);
        producer producer2 = new producer(sharedQueue,4);
        producer producer3 = new producer(sharedQueue,4);
        consumer consumer1 = new consumer(sharedQueue,4);
        consumer consumer2 = new consumer(sharedQueue,4);
        consumer consumer3 = new consumer(sharedQueue,4);
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);


        Thread.sleep(10*1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();


//      再睡一会关闭线程池
        Thread.sleep(3000);
        service.shutdown();
    }
}
