package com.demo.thread;

public class ConcurrencyTest {
    private static final long COUNT = 100000l;

    public static void main(String[] args) throws InterruptedException {
        serial();
        Concurrency();
    }

    /**
     * currentTimeMillis() --> Returns the current time in milliseconds.
     */
    private static void serial() {
        long start = System.currentTimeMillis();
        long s = System.currentTimeMillis();
        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }
        System.out.println("serial-child: " + (System.currentTimeMillis() - s));

        int a = 0;
        for (long i = 0; i < COUNT; i++) {
            a += 5;
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("serial: " + time + "ms,a= " + a);
    }

    /**
     * InterruptedException:
     * Thrown when a thread is waiting, sleeping, or otherwise occupied,
     * and the thread is interrupted, either before or during the activity.
     * Occasionally a method may wish to test whether the current thread has been interrupted,
     * and if so, to immediately throw this exception.
     *
     * @throws InterruptedException
     * 这个异常一般发生在线程中，当一个正在执行的线程被中断时就会出现这个异常
     * 假如有两个线程，第一个线程正在运行，第二个没有运行，这时第二个线程启动运行并要求中断第一个线程，
     * 第一个线程就会出现InterruptedException异常并执行该异常下的语句。
     */
    private static void Concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        /* Thread类的构造方法中，需要一个实现了Runnable接口的对象，而new就是生成了个实现Runnable接口的类的一个实例对象。把这个实例作为Thread的参数
         * 接口不能实例化，new Runnable()是一个实现接口Runnable的类的对象，后面的run方法是该类里实现的方法，这是匿名内部类的写法
         */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < COUNT; i++) {
                    a += 5;
                }
            }
        });
        /* 线程必须要先start，才能join，只有启动了，才能对线程进行操作 */
        thread.start(); // 启动thread线程
        long s = System.currentTimeMillis();
        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }
        System.out.println("Concurrency-child: " + (System.currentTimeMillis() - s));
        /* join的话则是将该线程加入到调用线程（一般为主线程） 等该线程结束后 调用线程才会继续运行 */
        thread.join(); // 邀请thread线程先执行，本线程先暂停执行，等待thread线程执行完后，主线程再接着往下执行
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency : " + time + "ms");

    }
}
