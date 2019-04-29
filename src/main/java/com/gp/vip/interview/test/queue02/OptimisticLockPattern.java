package com.gp.vip.interview.test.queue02;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2. 乐观锁的实现
 */
public class OptimisticLockPattern  {
    public static void main(String[] args) {
        SelfQueue selfqueue = new SelfQueue();

        //创建生产者线程和消费者线程
        Thread prodThread = new Thread(new Producer1(selfqueue));
        Thread consThread = new Thread(new Consumer1(selfqueue));

        //启动生产者线程和消费者线程
        prodThread.start();
        consThread.start();


        /*ThreadPoolExecutor productPool =
                new ThreadPoolExecutor(10,20,60, TimeUnit.MILLISECONDS,new ArrayBlockingQueue(5),new ThreadPoolExecutor.CallerRunsPolicy());
        ThreadPoolExecutor consumerPool =
                new ThreadPoolExecutor(10,20,60,TimeUnit.MILLISECONDS,new ArrayBlockingQueue(5),new ThreadPoolExecutor.CallerRunsPolicy());

        System.out.println("start");
        for(int i = 0;i<20;i++) {

            productPool.execute(new Producer1(selfqueue));
            consumerPool.execute(new Consumer1(selfqueue));
        }
        productPool.shutdown();
        consumerPool.shutdown();*/


    }
}

//自创队列
class SelfQueue {
    int max = 5;
    LinkedList<Integer> ProdLine = new LinkedList<Integer>();
    Lock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition empty = lock.newCondition();

    public void produce(int ProdRandom) {
        try {
            lock.lock();
            while(max == ProdLine.size()) {
                System.out.println("存储量达到上限，请等待");
                full.await();
            }
            ProdLine.add(ProdRandom);
            empty.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public int consume() {
        int m = 0;
        try{
            lock.lock();
            while(ProdLine.size() == 0) {
                System.out.println("队列为空，请等待");
                empty.await();
            }
            m = ProdLine.removeFirst();
            full.signal();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
            return m;
        }
    }
}
//生产者
class Producer1 implements Runnable {

    private final SelfQueue selfQueue;

    public Producer1(SelfQueue selfQueue) {
        this.selfQueue = selfQueue;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            Random random = new Random();
            int ProdRandom = random.nextInt(10);
            System.out.println("ProdRandom: " + ProdRandom);
            selfQueue.produce(ProdRandom);
        }
    }
}

//消费者
class Consumer1 implements Runnable {

    private final SelfQueue selfQueue;

    public Consumer1(SelfQueue selfQueue) {
        this.selfQueue = selfQueue;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("Consumed:" + selfQueue.consume());
        }
    }


}
