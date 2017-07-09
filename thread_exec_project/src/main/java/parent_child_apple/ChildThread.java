package parent_child_apple;

/**
 * Created by User on 25.06.2017.
 */
public class ChildThread extends Thread {
    private GlobalStorage globalStorage;

    public ChildThread(GlobalStorage globalStorage) {
        this.globalStorage = globalStorage;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child::" + globalStorage.getValue());
                Thread.sleep(100);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
