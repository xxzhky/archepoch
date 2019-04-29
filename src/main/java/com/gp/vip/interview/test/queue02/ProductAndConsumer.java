package com.gp.vip.interview.test.queue02;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProductAndConsumer {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(20);
        //为多生产者和多消费者分别开创的线程池
        ThreadPoolExecutor productPool =
                new ThreadPoolExecutor(10, 20, 60, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5), new ThreadPoolExecutor.CallerRunsPolicy());
        ThreadPoolExecutor consumerPool =
                new ThreadPoolExecutor(10, 20, 60, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5), new ThreadPoolExecutor.CallerRunsPolicy());

        System.out.println("start");
        for (int i = 0; i < 100; i++) {

            productPool.execute(new ProductThread(i, queue));
            consumerPool.execute(new ConsumerThread(queue));
        }
        productPool.shutdown();
        consumerPool.shutdown();
    }

}

class ConsumerThread extends Thread {
    private ArrayBlockingQueue queue;

    public ConsumerThread(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        System.out.println("准备消费");
        int taskNum;
        try {
            taskNum = (int) queue.take();
            System.out.println("消费了" + taskNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ProductThread extends Thread {
    private int taskNum;
    private ArrayBlockingQueue queue;

    public ProductThread(int taskNum, ArrayBlockingQueue queue) {
        this.taskNum = taskNum;
        this.queue = queue;
    }

    public void run() {
        try {
            //模拟生产
            Thread.currentThread().sleep(5000);
            System.out.println("开始生产");
            queue.add(taskNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}