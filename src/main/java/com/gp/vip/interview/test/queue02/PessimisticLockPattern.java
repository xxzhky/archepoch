package com.gp.vip.interview.test.queue02;

import java.util.Random;

/**
 * 3. 悲观锁实现
 */
public class PessimisticLockPattern {
    public static void main(String[] args) {
        SelfQueue2 selfqueue = new SelfQueue2();

        //创建生产者线程和消费者线程
        Thread prodThread = new Thread(new Producer2(selfqueue));
        Thread consThread = new Thread(new Consumer2(selfqueue));

        //启动生产者线程和消费者线程
        prodThread.start();
        consThread.start();
    }
}

class SelfQueue2{
    int index = 0;
    int[] ProdLine = new int[6];

    public synchronized void produce(int ProdRandom){
        while(index == ProdLine.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        ProdLine[index] = ProdRandom;
        index++;
    }

    public synchronized int consume() {
        while(index == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return ProdLine[index];
    }
}


//生产者
class Producer2 implements Runnable {

    private final SelfQueue2 selfqueue;

    public Producer2(SelfQueue2 selfqueue) {
        this.selfqueue = selfqueue;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            Random random = new Random();
            int ProdRandom = random.nextInt(10);
            System.out.println("Produced: " +ProdRandom);
            selfqueue.produce(ProdRandom);
        }
    }
}

//消费者
class Consumer2 implements Runnable {
    private final SelfQueue2 selfqueue;

    public Consumer2(SelfQueue2 selfqueue) {
        this.selfqueue = selfqueue;
    }
    @Override
    public void run() {
        while(true) {
            System.out.println("Consumed: " + selfqueue.consume());
        }
    }

}
