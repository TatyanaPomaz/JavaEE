package parent_child_apple;

/**
 * Created by User on 25.06.2017.
 */
public class GlobalStorage {
    private int value;
    private boolean isEmpty = true;

    synchronized public int getValue() throws InterruptedException {
        if (isEmpty) {
            wait();
        }
        isEmpty = true;
        notify();
       // System.out.println("Child:: value =" + value);
        return value;
    }

    synchronized public void setValue(int value) throws InterruptedException {
        if (!isEmpty) {
            wait();
        }
        System.out.println("Parent:: value =" + value);
        this.value = value;
        isEmpty = false;
        notify();
    }
}
