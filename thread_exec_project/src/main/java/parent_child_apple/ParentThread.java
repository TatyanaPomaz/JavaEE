package parent_child_apple;

/**
 * Created by User on 25.06.2017.
 */
public class ParentThread extends Thread {
    private GlobalStorage globalStorage;

    public ParentThread(GlobalStorage globalStorage) {
        this.globalStorage = globalStorage;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                globalStorage.setValue(i);
                Thread.sleep(100);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
