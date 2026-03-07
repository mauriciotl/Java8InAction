package lambdasinaction.chap2.mauPractice05_Thread.interfaces;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - This is my Runnable implementation!! the task!!");
    }
}
