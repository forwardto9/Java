package my.thread.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: uwei
 * create:2022-04-02
 */
public class Concurrent {
    public static void main(String[] args) throws InterruptedException {
        var q = new TaskQueue();
        var ts = new ArrayList<Thread>();

        // 多个线程等待执行任务
        for (int i = 0; i < 5; i++) {
            var t = new Thread() {
                @Override
                public void run() {
                    super.run();
                    while (true) {
                        try {
                            String s = q.getTask();
                            System.out.println("execute task: " + s + " on thread: " + Thread.currentThread().getName());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
            };
            t.start();
            ts.add(t);
        }


        var add = new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                String s = "t_" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                // 留出空隙，让getTask有机会执行
                try { Thread.sleep(100); } catch (Exception ignored) {}
            }
        });

        // 被添加到队列的任务，被哪一个线程执行，由系统决定，
        // 即虽然开了5个线程，但是可能有的线程是没有被分配到任务
        // 原因是使用了notifyAll，唤醒了全部线程，导致竞争
        add.start();
        add.join(); // 让执行add的线程等待add执行结束
        for (var t: ts) {
            t.interrupt();
        }
    }
}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    // 高性能锁
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    // 重锁
//    public synchronized void addTask(String s) {
//        this.queue.add(s);
//        this.notifyAll();
//    }
//
//    public synchronized String getTask() throws InterruptedException {
//        System.out.println("try to get task");
//        while (queue.isEmpty()) {
//            this.wait();
//        }
//        return queue.remove();
//    }


    public void addTask(String s) {
        lock.lock();
        this.queue.add(s);
        condition.signalAll();
        lock.unlock();
    }

    public String getTask() throws InterruptedException {
        System.out.println("try to get task");
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }

}