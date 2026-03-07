package lambdasinaction.chap2.mauPractice05_Thread.thread;

public class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " - This is MyThread run() method implementation!!, the task!!");
    }


}
