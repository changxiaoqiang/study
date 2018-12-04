package com.demo.test;

public class Demo {
    //main 方法本身放入方法区。
    public volatile static Boolean isOpen = true;

    public static void main(String[] args) {
        Sample test1 = new Sample(" 测试1 ");   //test1是引用，所以放到栈区里， Sample是自定义对象应该放到堆里面
        Sample test2 = new Sample(" 测试2 ");
//        test1.printName();
//        test2.printName();

        int intArray[][][] = {{{0, 1, 2, 3}}};
        System.out.println(intArray[0][0][2]);

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    synchronized (isOpen) {
                    Thread.sleep(5000);
                    isOpen = false;
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                System.out.println("OK");
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    synchronized (isOpen) {
                    int i = 0;
                    while (isOpen) {
//                        Thread.sleep(2);
                        i++;
                    }
                    System.out.println(i);
//                    }
                    System.out.println("stop");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        threadB.start();
    }

}

//运行时, jvm 把appmain的信息都放入方法区
class Sample {
    /** 范例名称 */
    private String name;      //new Sample实例后， name 引用放入栈区里，  name 对象放入堆里

    /** 构造方法 */
    public Sample(String name) {
        this.name = name;
    }

    /** 输出 */
    //print方法本身放入 方法区里。
    public void printName() {
        System.out.println(name);
    }
}

