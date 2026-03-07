package lambdasinaction.chap2.mauPractice05_Thread;

import lambdasinaction.chap2.mauPractice05_Thread.interfaces.MyRunnable;
import lambdasinaction.chap2.mauPractice05_Thread.thread.MyThread;

public class ThreadExample {

    public static void main(String[] args) {

        //1. By implementing my Runnable
        Runnable myRunnable = new MyRunnable();
        Thread thread01 = new Thread(myRunnable, "tread-01");
        thread01.start();

        //2. By Extending Thread
        Thread thread02 = new MyThread();
        thread02.setName("tread-02");
        thread02.start();


        //3. By built-in implementation
        Thread thread03 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " - This is built-in implementation!!, The task");
            }
        }, "tread-03");
        thread03.start();





    }


}
