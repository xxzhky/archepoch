package com.gp.vip.interview.test.queue02;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 1. 阻塞队列实现生产者消费者模式
 */
public class BlockingQueuePattern {
    public static void main(String[] args) {

        //阻塞队列
        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        //创建生产者线程和消费者线程
        Thread prodThread = new Thread(new Producer(sharedQueue));
        Thread consThread = new Thread(new Consumer(sharedQueue));

        //启动生产消费者
        prodThread.start();
        consThread.start();
    }
}

//生产者
class Producer implements Runnable {

    private final BlockingQueue sharedQueue;

    public Producer(BlockingQueue shareQueue) {
        this.sharedQueue = shareQueue;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            //产生10以内的随机整数放入阻塞队列
            Random random = new Random();
            int ProdRandom = random.nextInt(10);
            System.out.println("Produced: " + ProdRandom);
            try {
                sharedQueue.put(ProdRandom);
            } catch (InterruptedException e) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}

//消费者
class Consumer implements Runnable {

    private final BlockingQueue sharedQueue;

    public Consumer (BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("Consumed: " + sharedQueue.take());
            } catch (InterruptedException e) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, e);;
            }

        }
    }
}
