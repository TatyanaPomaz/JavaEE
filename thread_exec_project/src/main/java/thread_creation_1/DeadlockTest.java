package thread_creation_1;

/**
 * Created by User on 25.06.2017.
 */
public class DeadlockTest {
    public static void main(String[] args) {
        final Object obj1 = new Object();
        final Object obj2 = new Object();

        new Thread() {
            public void run() {
                synchronized (obj1) {
                    System.out.println("obj1 was locked by thread1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj2){
                        System.out.println("obj2 was locked by thread1");
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                synchronized (obj2){
                    System.out.println("obj2 was locked by thread2");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj1){
                        System.out.println("obj1 was locked by thread 2");
                    }
                }
            }
        }.start();

    }
}
