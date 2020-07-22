package ProducerAndConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/7/22
 * \* Time: 16:25
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class ConsumerWithBQ implements Runnable{

    private BlockingQueue<Integer> queue;
    private static final int SLEEPTIME = 1000;

    public ConsumerWithBQ(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    public void run(){
        int data;
        Random r = new Random();

        System.out.println("start consumer id = " + Thread.currentThread().getId());

        try{
            while (true){
                Thread.sleep(r.nextInt(SLEEPTIME));

                if(!queue.isEmpty()){
//                    消费数据，获取并移除此队列的头部，在元素变得可用之前一直等待 。queue的长度 == 0 的时候，一直阻塞
                    data = queue.take();
                    System.out.println("consumer" + Thread.currentThread().getId() + "consume data； " + data
                    + " , size" + queue.size());
                }else {
                    System.out.println("queue is empty,consumer " + Thread.currentThread().getId()
                    + " is waiting ,size:"+ queue.size());
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue();

        ExecutorService service = Executors.newCachedThreadPool();
        ProducerWithBQ producer1 = new ProducerWithBQ(sharedQueue);
        ProducerWithBQ producer2 = new ProducerWithBQ(sharedQueue);
        ProducerWithBQ producer3 = new ProducerWithBQ(sharedQueue);
        ConsumerWithBQ consumer1 = new ConsumerWithBQ(sharedQueue);
        ConsumerWithBQ consumer2 = new ConsumerWithBQ(sharedQueue);
        ConsumerWithBQ consumer3 = new ConsumerWithBQ(sharedQueue);

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

        Thread.sleep(1000);
        service.shutdown();
    }
}
