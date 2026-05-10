package lambdasinaction.chap3.mauPractice;

public class LambdaSyntax {

    public static void main(String[] args) {


        Runnable r1 = () -> {
            System.out.println("Hello lambda wordl!!");
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from a anonymous class!!");
            }
        };

        process(r1);
        process(r2);
        process(() -> {
            System.out.println("Hello from Lambda-Inline implementation!!");
        });
        process(() -> System.out.println("Hello from Lambda-Inline implementation 02!!"));
    }


    public static void process(Runnable runnable){
        runnable.run();
    }


}
