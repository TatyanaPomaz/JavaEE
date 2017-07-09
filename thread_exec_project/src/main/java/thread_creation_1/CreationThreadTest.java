package thread_creation_1;

/**
 * Created by User on 25.06.2017.
 */
public class CreationThreadTest {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread = Thread.currentThread();
//        System.out.println(thread.getName());
//        thread.setName("new thread name");
//
//        System.out.println(thread.getName());


        CustomThread customThread = new CustomThread();
        customThread.start();
        customThread.join();

        CustomRunnable customRunnable = new CustomRunnable();
        new Thread(customRunnable).start();


    }
}

class CustomThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("CustomThread::" + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doSomething() {

    }
}


class CustomRunnable implements Runnable {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("CustomRunnable::" + Thread.currentThread().getName());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}